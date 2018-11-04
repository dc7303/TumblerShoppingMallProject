package edu.shoppingMall.service;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.OrderDTO;


/**
 * �ֹ� ���� Service Interface�Դϴ�.
 * ���� �������� ����ϴ� ���μ����Դϴ�.
 * @author mark
 *
 */
public interface OrderService {
    
    /**
     * �ֹ� ��ȸ
     */
    List<OrderDTO> orderSelectAll() throws SQLException;
    
    /**
     * �ֹ� �߰�
     */
    int orderInsert(OrderDTO dto) throws SQLException;
    
    /**
     * �ֹ� ����
     */
    int orderUpdate(OrderDTO dto) throws SQLException;
    
    /**
     * �ֹ� ���
     */
    int orderDelete(int orderNum) throws SQLException;
    
    
}
