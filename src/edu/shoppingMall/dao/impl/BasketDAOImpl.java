package edu.shoppingMall.dao.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.BasketDAO;
import edu.shoppingMall.dto.BasketDTO;

public class BasketDAOImpl implements BasketDAO {
    private static BasketDAOImpl basketDAO = new BasketDAOImpl();
    
    public static BasketDAOImpl getInstance() {
        return basketDAO;
    }
    
    /**
     *  ��ٱ��� ��ü��ȸ
     */
    @Override
    public List<BasketDTO> basketSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��ٱ��� Ű���� ��ȸ(��ٱ��� ��ȣ��ȸ)
     */
    @Override
    public BasketDTO basketSelectByBasketNum(int basketNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��ٱ��� Ű���� ��ȸ(���� ID ��ȸ)
     */
    @Override
    public List<BasketDTO> basketSelectByUserId(String userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��ٱ��� �߰�
     */
    @Override
    public int basketInsert(BasketDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * ��ٱ��� ����
     */
    @Override
    public int basketUpdate(BasketDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * ��ٱ��� ����
     */
    @Override
    public int baksetDelete(int basketNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
