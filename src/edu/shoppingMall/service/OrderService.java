package edu.shoppingMall.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.shoppingMall.dto.BasongDTO;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.dto.OrderDetailDTO;


/**
 * �ֹ� ���� Service Interface�Դϴ�.
 * ���� �������� ����ϴ� ���μ����Դϴ�.
 * @author mark
 *
 */
public interface OrderService {
    
    /**
     * �ֹ� ��ȸ(BasongDTO, OrderDetailDTO ������ OrderDTO�� �����Ѵ�
     */
    List<OrderDTO> orderSelectAll() throws SQLException;
    
    /**
     * �ֹ� Ű���� �˻� (ID ��ȸ, BasongDTO, OrderDetailDTO ������ OrderDTO�� �����Ѵ�)
     * ID�� �Ķ���ͷ� �޾� �ֹ���, �ֹ� ���� ID�� ��ȸ ������ DAO �޼ҵ带 ����� �� �ִ�.
     */
    List<OrderDTO> orderSelectByUserId(String userId) throws SQLException;
    
    /**
     * �ֹ� Ű���� �˻� (�ֹ���ȣ ��ȸ)
     * �ֹ���ȣ�� �Ķ���ͷ� �޾� ���, �ֹ���, �ֹ� ���� �ֹ���ȣ�� ��ȸ ������ DAO �޼ҵ带 ����� �� �ִ�.
     */
    OrderDTO orderSelectByOrderNum(int orderNum) throws SQLException;
    
    /**
     * �ֹ� �߰�( BasongDTO, OrderDetailDTO ������ OrderDTO�� �޴´�)
     */
    int orderInsert(OrderDTO orderDTO) throws SQLException;
    
    /**
     * ��ٱ��Ͽ��� �ֹ�
     * UserId�� �޾� ��ٱ��� ��ȸ - > �ֹ� ���̺� ���� - > ������ ��ȸ - > �ݺ������� �����ϰ� ��� ���̺� ����
     */
    int orderInsertByBasket(String userId, String comment, BasongDTO basongDTO) throws SQLException;
    
    /**
     * �ֹ� ����
     */
    int orderUpdate(OrderDTO dto) throws SQLException;
    
    /**
     * �ֹ� ���
     */
    int orderDelete(int orderNum) throws SQLException;
    
    
}
