package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.BasketDTO;
import edu.shoppingMall.service.BasketService;

public class BasketServiceImpl implements BasketService {
    private static BasketServiceImpl service = new BasketServiceImpl();
    
    public static BasketServiceImpl getInstance () {
        return service;
    }
    
    /**
     * ��ٱ��� ��ü��ȸ
     */
    @Override
    public List<BasketDTO> basketSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��ٱ��� Ű���� ��ȸ (��ٱ��� ��ȣ)
     */
    @Override
    public BasketDTO basketSelectByBasketNum(int basketNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��ٱ��� Ű���� ��ȸ (���� ID�� ��ȸ)
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
