package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.BasongDTO;
import edu.shoppingMall.dto.OrderDetailDTO;

public interface BasongDAO {
    /**
     * ��� ��ü ��ȸ
     */
    List<BasongDTO> basongSelectAll() throws SQLException;
    
    /**
     * ��� Ű���� �˻� (�ֹ���ȣ�� �˻�)
     */
    List<BasongDTO> basongSelectByOrderNum(int orderNum) throws SQLException;
    
    /**
     * ��� Ű���� �˻� (�����ȣ �˻�)
     */
    List<BasongDTO> basongSelectByInvoiceNum(String basongInvoiceNum) throws SQLException;
    
    /**
     * ��� �߰�
     */
    int basongInsert(BasongDTO dto) throws SQLException;
    
    /**
     * ��� ����
     */
    int basongUpdate(BasongDTO dto) throws SQLException;
    
    /**
     * ��� ����(�ֹ���ȣ�� ����)
     */
    int basongDelete(int orderNum) throws SQLException;
}
