package edu.shoppingMall.service;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.BasketDTO;

public interface BasketService {
    /**
     * ��ٱ��� ��ü�˻�
     * @return
     * @throws SQLException
     */
    List<BasketDTO> basketSelectAll() throws SQLException;
    
    /**
     * ��ٱ��� Ű���� �˻� (��ٱ��� ��ȣ�� �˻�)
     * @return
     * @throws SQLException
     */
    BasketDTO basketSelectByBasketNum(int basketNum) throws SQLException;
    
    /**
     * ��ٱ��� Ű���� �˻� (���� ID�� �˻�)
     * @return
     * @throws SQLException
     */
    List<BasketDTO> basketSelectByUserId(String userId) throws SQLException;
    
    /**
     * ��ٱ��� ����
     * @return
     * @throws SQLException
     */
    int basketInsert(BasketDTO dto) throws SQLException;
    
    /**
     * ��ٱ��� ����
     * @return
     * @throws SQLException
     */
    int basketUpdate(BasketDTO dto) throws SQLException;
    
    /**
     * ��ٱ��� ����
     * @param basketNum
     * @return
     * @throws SQLException
     */
    int baksetDelete(int basketNum) throws SQLException;
}
