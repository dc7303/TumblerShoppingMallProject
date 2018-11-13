package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.dto.OrderDetailDTO;

public interface OrderDetailDAO {
    /**
     * �ֹ� �� ��ȸ
     */
    List<OrderDetailDTO> orderDetailSelectAll() throws SQLException;
    
    /**
     * �ֹ� �� Ű���� (���� ID �˻� )
     */
    List<OrderDetailDTO> orderDetailSelectByUserId(String userId) throws SQLException;
    
    /**
     * �ֹ� �� Ű���� ( �ֹ� ��ȣ �˻� )
     */
    OrderDetailDTO orderDetailSelectByOrderNum(int orderNum) throws SQLException;
    
    /**
     * �ֹ� �� �߰�
     */
    int orderDetailInsert(OrderDetailDTO dto) throws SQLException;
    
    /**
     * �ֹ� �� ����
     */
    int orderDetailUpdate(OrderDetailDTO dto) throws SQLException;
    
    /**
     * �ֹ� �� ����(�ֹ���ȣ�� ����)
     */
    int orderDetailDelete(int orderNum) throws SQLException;
}
