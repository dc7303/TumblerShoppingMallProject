package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.BasongDAO;
import edu.shoppingMall.dao.OrderDAO;
import edu.shoppingMall.dao.OrderDetailDAO;
import edu.shoppingMall.dao.impl.BasongDAOImpl;
import edu.shoppingMall.dao.impl.OrderDAOImpl;
import edu.shoppingMall.dao.impl.OrderDetailDAOImpl;
import edu.shoppingMall.dto.OrderDTO;
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
     */
    @Override
    public List<OrderDTO> orderSelectAll() throws SQLException {

        return null;
    }

    /**
     * 주문 조회 UserID로 조회하기 리턴값은 (OrderDetailDTO와 BasongDTO를 포함한 DTO를 리턴한다.) ID를 파라미터로
     * 받아 주문상세, 주문 각각 ID로 조회 가능한 DAO 메소드를 사용할 수 있다.
     */
    @Override
    public List<OrderDTO> orderSelectByUserId(String userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 주문번호로 검색하기 (OrderDetailDTO와 BasongDTO를 포함한 DTO를 리턴한다.) 주문번호를 파라미터로 받아 배송,
     * 주문상세, 주문 각각 주문번호로 조회 가능한 DAO 메소드를 사용할 수 있다.
     */
    @Override
    public OrderDTO orderSelectByOrderNum(int orderNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 주문 생성
     */
    @Override
    public int orderInsert(OrderDTO dto) throws SQLException {

        return 0;
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
        return 0;
    }

}
