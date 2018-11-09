package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.BasongDAO;
import edu.shoppingMall.dao.OrderDAO;
import edu.shoppingMall.dao.OrderDetailDAO;
import edu.shoppingMall.dao.ProductInfoDAO;
import edu.shoppingMall.dao.impl.BasongDAOImpl;
import edu.shoppingMall.dao.impl.OrderDAOImpl;
import edu.shoppingMall.dao.impl.OrderDetailDAOImpl;
import edu.shoppingMall.dao.impl.ProductInfoDAOImpl;
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
     */
    @Override
    public List<OrderDTO> orderSelectByUserId(String userId) throws SQLException {
        List<OrderDTO> list = orderDAO.orderSelectByUserId(userId);
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
        int result = orderResult + detailResult + basongResult;
        
        return result;
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
        
        result = basongResult + detailResult + orderResult;
        return result;
    }

}
