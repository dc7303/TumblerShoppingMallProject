package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.BasketDAO;
import edu.shoppingMall.dao.BasongDAO;
import edu.shoppingMall.dao.OrderDAO;
import edu.shoppingMall.dao.OrderDetailDAO;
import edu.shoppingMall.dao.ProductInfoDAO;
import edu.shoppingMall.dao.impl.BasketDAOImpl;
import edu.shoppingMall.dao.impl.BasongDAOImpl;
import edu.shoppingMall.dao.impl.OrderDAOImpl;
import edu.shoppingMall.dao.impl.OrderDetailDAOImpl;
import edu.shoppingMall.dao.impl.ProductInfoDAOImpl;
import edu.shoppingMall.dto.BasketDTO;
import edu.shoppingMall.dto.BasongDTO;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.dto.OrderDetailDTO;
import edu.shoppingMall.dto.ProductDTO;
import edu.shoppingMall.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private static OrderServiceImpl service = new OrderServiceImpl();
    private OrderDAO orderDAO = OrderDAOImpl.getInstance();
    private OrderDetailDAO detailDAO = OrderDetailDAOImpl.getInstance();
    private BasongDAO basongDAO = new BasongDAOImpl().getInstance();
    private BasketDAO basketDAO = new BasketDAOImpl().getInstance();
    private ProductInfoDAO productDAO =  new ProductInfoDAOImpl().getInstance();
    
    public static OrderServiceImpl getInstance() {
        return service;
    }
    

    /**
     * 주문 전체 검색 (OrderDetailDTO와 BasongDTO를 포함한 DTO를 리턴한다.)
     * 관리자 판매 내역 확인.
     */
    @Override
    public List<OrderDTO> orderSelectAll() throws SQLException {
        List<OrderDTO> list = orderDAO.orderSelectAll();
        if(list == null) {
            throw new SQLException("판매내역이 없습니다. 다시 확인해주세요.");
        }
        return list;
    }
    
    /**
     * 주문 조회 UserID로 조회하기 리턴값은 (OrderDetailDTO와 BasongDTO를 포함한 DTO를 리턴한다.) ID를 파라미터로
     * 받아 주문상세, 주문 각각 ID로 조회 가능한 DAO 메소드를 사용할 수 있다.
     * 고객 마이페이지 주문내역 확인
     * 
     * basongFlage 파라미터로 주문내역, 지난 결제내역 분리해서 사용가능.
     */
    @Override
    public List<OrderDTO> orderSelectByUserId(String userId, String basongFlag) throws SQLException {
        List<OrderDTO> list = orderDAO.orderSelectByUserId(userId, basongFlag);
        if(list == null) {
            throw new SQLException("주문하신 내역이 없습니다.");
        }
        return list;
    }

    /**
     * 주문번호로 검색하기 (OrderDetailDTO와 BasongDTO를 포함한 DTO를 리턴한다.) 주문번호를 파라미터로 받아 배송,
     * 주문상세, 주문 각각 주문번호로 조회 가능한 DAO 메소드를 사용할 수 있다.
     * 주문 상세내역 확인
     */
    @Override
    public OrderDTO orderSelectByOrderNum(int orderNum) throws SQLException {
        OrderDTO orderDTO = orderDAO.orderSelectByOrderNum(orderNum);
        if(orderDTO == null) {
            throw new SQLException("검색하신 주문번호는 없는 번호입니다.");
        }
        return orderDTO;
    }

    /**
     * 주문 생성 서비스 영역
     * 프로세서 순서. 상품가격불러옴 - > 주문생성 -> 주문상세 생성 -> 배송 생성
     * 상품가격을 productSelectByProNum 메소드를 이용해 가져와서 수량과 곱한 후 주문 상세와 주문 가격에 셋팅해준다.
     */
    @Override
    public int orderInsert(OrderDTO dto) throws SQLException {
        ProductInfoDAO proDAO = ProductInfoDAOImpl.getInstance();
        OrderDetailDTO detailDTO = dto.getDetailDTO();
        BasongDTO basongDTO = dto.getBasongDTO();
        int proNum = detailDTO.getProductNum();
        
        ProductDTO proDTO = proDAO.productSelectByProductNum(detailDTO.getProductNum());    //상품번호 입력
        if(proDTO == null) {
            throw new SQLException("주문 요청하신 상품은 존재하지 않습니다");
        }else if (proDTO.getProductQuantity() == 0) {
            throw new SQLException("주문하신 상품의 재고가 없습니다.");
        }
        
        int price = proDTO.getProductPrice();                   //상품가겨
        int amount = detailDTO.getOrderDetailQuantity();        //주문수량
        int orderPrice = price * amount;            //주문 상세 가격, 주문 가격
        
        //Order 생성(생성가격 매개변수로 전달)
        System.out.println("연결");
        int orderResult = orderDAO.orderInsert(new OrderDTO(dto.getOrderUserId(), dto.getOrderComment(), orderPrice));
        if(orderResult == 0) {
            throw new SQLException("주문 정보가 일치하지 않습니다.");
        }
        
        int orderNum = orderDAO.orderSeqSearch();               //마지막 생성된 주문 시퀀스값 가져오기.
         
        //OrderDetail 생성
        detailDTO.setOrderNum(orderNum);                                            //주문번호셋팅
        detailDTO.setOrderDetailPrice(orderPrice);                                  //상세 가격 셋팅
        int detailResult = detailDAO.orderDetailInsert(detailDTO);
        if(detailResult == 0) {
            orderDAO.orderDelete(orderNum);                                         //실패시 order테이블 삭제
            throw new SQLException("주문 상세 정보가 잘못됐습니다.");
        }
        
        //Delivery 생성
        basongDTO.setOrderNum(orderNum);                   //주문번호셋팅
        int basongResult = basongDAO.basongInsert(basongDTO);
        if(basongResult == 0) {
            basongDAO.basongDelete(orderNum);
            detailDAO.orderDetailDelete(orderNum); 
            orderDAO.orderDelete(orderNum);                                         //실패시 order테이블 삭제
                                             //실패시 detail테이블 삭제
            throw new SQLException("배송 정보 입력이 잘못됐습니다.");
        }
        
        //주문한 상품 수량 감소
        productDAO.productUpdateForQuantity(proNum, amount);
        
        return basongResult;
    }

    /**
     * 장바구니에서 주문
     * UserId를 받아 장바구니 조회 - > 주문 테이블 생성 - > 시퀀스 조회 - > 반복문으로 디테일과 배송 테이블 생성
     */
    @Override
    public int orderInsertByBasket(String userId, String comment, BasongDTO basongDTO) throws SQLException {
        //장바구니 리스트 유저아이디로 불러오기.
        List<BasketDTO> list = basketDAO.basketSelectByUserId(userId);
        if(list == null) {
            throw new SQLException("장바구니가 존재하지 않습니다.");
        }
        
        //주문 테이블 생성하기
        int orderResult = orderDAO.orderInsert(new OrderDTO(userId, comment));
        if(orderResult == 0) {
            throw new SQLException("주문에 실패했습니다.");
        }
        
        int orderNum = orderDAO.orderSeqSearch();   //시퀀스값 가져오기
        
        int totalPrice = 0;                         //총 결제금액
        //반복문으로 장바구니 상품 디테일 생성
        for(int i = 0; i < list.size(); i++) {
            int proNum = list.get(i).getProductNum();           //상품번호
            int price = list.get(i).getBasketPrice();           //가격
            int amount = list.get(i).getBasketQuantity();       //주문수량
            String option = list.get(i).getBasketOption();      //옵션
            
            //총 구매금액 누적
            totalPrice += (price * amount);
            
            //주문한 상품 수량 감소
            productDAO.productUpdateForQuantity(proNum, amount);
            
            //주문상세 테이블 생성
            int deatilResult = detailDAO.orderDetailInsert(new OrderDetailDTO(orderNum, proNum, price, amount, option));
            if(deatilResult == 0) {
                //복수 결제 반복문을 돌면서 그전 생성된 테이블이 있다면 삭제
                if(detailDAO.orderDetailSelectByOrderNum(orderNum) != null) {       
                    detailDAO.orderDetailDelete(orderNum);
                }
                orderDAO.orderDelete(orderNum);
                throw new SQLException("주문 상세정보가 잘못되었습니다.");
            }
        }
        
        //배송 테이블 생성
        basongDTO.setOrderNum(orderNum);
        int basongResult = basongDAO.basongInsert(basongDTO);
        if(basongResult == 0) {
            detailDAO.orderDetailDelete(orderNum);
            orderDAO.orderDelete(orderNum);
            throw new SQLException("배송정보가 잘못되었습니다.");
        } 
        
        //주문 총 가격 업데이트
        int priceUpdate = orderDAO.orderUpdate(orderNum, totalPrice);
        
        //장바구니 내역 삭제
        int basketResult = basketDAO.basketDelete(userId);
        if(basketResult == 0) {
            throw new SQLException("장바구니가 비워지지 않았습니다. 확인해주세요.");
        }
        
        return basongResult;
    }
    
    /**
     * 주문내역 수정
     */
    @Override
    public int orderUpdate(OrderDTO dto) throws SQLException {
        return 0;
    }

    /**
     * 주문취소 삭제
     */
    @Override
    public int orderDelete(int orderNum) throws SQLException {
        int result = 0;
        
        //배송테이블 삭제
        int basongResult = basongDAO.basongDelete(orderNum);
        if(basongResult == 0) {
            throw new SQLException("배송테이블 삭제가 불가능합니다.");
        }
        
        //디테일 테이블 삭제
        int detailResult = detailDAO.orderDetailDelete(orderNum);
        if(detailResult == 0){
            throw new SQLException("주문상세 테이블 삭제가 불가능합니다.");
        }
        
        //주문테이블 삭제
        int orderResult = orderDAO.orderDelete(orderNum);
        if(orderResult == 0) {
            throw new SQLException("주문 삭제가 불가능합니다.");
        }
        
        return basongResult;
    }

}
