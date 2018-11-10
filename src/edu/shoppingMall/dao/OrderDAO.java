package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.OrderDTO;


/**
 * �ֹ�DAO �����Դϴ�. �������� ���μ����Դϴ�.
 * ���߿� ��ٱ��Ͽ� ���� �� ������ �� �ִ� �κ������� ���� ��Ź�帳�ϴ�.
 * @author mark
 *
 */
public interface OrderDAO {
    
    /**
     * �ֹ� ��ȸ
     */
    List<OrderDTO> orderSelectAll() throws SQLException;
    
    /**
     * �ֹ� Ű���� �˻� (ID ��ȸ)
     */
    List<OrderDTO> orderSelectByUserId(String userId, String basongFlag) throws SQLException;
    
    /**
     * �ֹ� Ű���� �˻� (�ֹ���ȣ ��ȸ)
     */
    OrderDTO orderSelectByOrderNum(int orderNum) throws SQLException;
    
    
    /**
     * �������� ��������
     */
    public int orderSeqSearch() throws SQLException;
    
    /**
     * �ֹ� �߰�
     */
    int orderInsert(OrderDTO dto) throws SQLException;
    
    /**
     * �ֹ� ����
     */
    int orderUpdate(int orderNum, int price) throws SQLException;
    
    /**
     * �ֹ� ���
     */
    int orderDelete(int orderNum) throws SQLException;
    
    
}
