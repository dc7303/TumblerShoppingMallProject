package edu.shoppingMall.dao.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.OrderDetailDAO;
import edu.shoppingMall.dto.OrderDetailDTO;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    private static OrderDetailDAOImpl detailDAO = new OrderDetailDAOImpl();
    
    public static OrderDetailDAOImpl getInstance() {
        return detailDAO;
    }
    
    /**
     * �ֹ��� ��ü��ȸ
     */
    @Override
    public List<OrderDetailDTO> orderDetailSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * �ֹ��� �������̵�� ��ȸ
     */
    @Override
    public List<OrderDetailDTO> orderDetailSelectByUserId(String userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * �ֹ��� �ֹ� ��ȣ�� ��ȸ
     */
    @Override
    public OrderDetailDTO orderDetailSelectByOrderNum(int orderNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * �ֹ��� �߰�
     */
    @Override
    public int orderDetailInsert(OrderDetailDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    /**
     * �ֹ��� ����
     */
    @Override
    public int orderDetailUpdate(OrderDetailDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * �ֹ��� ����
     */
    @Override
    public int orderDetailDelete(int orderDetailNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
