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
     *  장바구니 전체조회
     */
    @Override
    public List<BasketDTO> basketSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 장바구니 키워드 조회(장바구니 번호조회)
     */
    @Override
    public BasketDTO basketSelectByBasketNum(int basketNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 장바구니 키워드 조회(유저 ID 조회)
     */
    @Override
    public List<BasketDTO> basketSelectByUserId(String userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 장바구니 추가
     */
    @Override
    public int basketInsert(BasketDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 장바구니 수정
     */
    @Override
    public int basketUpdate(BasketDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 장바구니 삭제
     */
    @Override
    public int baksetDelete(int basketNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
