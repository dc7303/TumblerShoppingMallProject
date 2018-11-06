package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.BasketDTO;

public interface BasketDAO {
    /**
     * ��ٱ��� ��ü�˻�
     * @return
     * @throws SQLException
     */
    List<BasketDTO> basketSelectAll() throws SQLException;
    
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
