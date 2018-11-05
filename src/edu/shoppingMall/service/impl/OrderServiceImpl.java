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
     * �ֹ� ��ü �˻�
     */
    @Override
    public List<OrderDTO> orderSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * �ֹ� ����
     */
    @Override
    public int orderInsert(OrderDTO dto) throws SQLException {
        int result = daoImpl.orderInsert(dto);
        if(result == 0) {
            throw new SQLException("�ֹ� �����߽��ϴ�.");
        }
        return result;
    }
    
    /**
     * �ֹ����� ����
     */
    @Override
    public int orderUpdate(OrderDTO dto) throws SQLException {
        return 0;
    }

    /**
     * �ֹ���� ����
     */
    @Override
    public int orderDelete(int orderNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
