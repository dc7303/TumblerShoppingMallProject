package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.OrderDAO;
import edu.shoppingMall.dao.impl.OrderDAOImpl;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private static OrderServiceImpl service = new OrderServiceImpl();
    private OrderDAO daoImpl = OrderDAOImpl.getInstance();
    
    
    public static OrderServiceImpl getInstance() {
        return service;
    }
    /**
     * 주문 전체 검색
     */
    @Override
    public List<OrderDTO> orderSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 주문 생성
     */
    @Override
    public int orderInsert(OrderDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    /**
     * 주문내역 수정
     */
    @Override
    public int orderUpdate(OrderDTO dto) throws SQLException {
        int result = daoImpl.orderInsert(dto);
        return result;
    }

    /**
     * 주문취소 삭제
     */
    @Override
    public int orderDelete(int orderNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
