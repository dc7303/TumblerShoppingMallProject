package edu.shoppingMall.dao.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.BasongDAO;
import edu.shoppingMall.dto.BasongDTO;

public class BasongDAOImpl implements BasongDAO {
    private static BasongDAOImpl basongDAO = new BasongDAOImpl();
    
    public static BasongDAOImpl getInstance() {
        return basongDAO;
    }
    
    /**
     * 배송 전체조회
     */
    @Override
    public List<BasongDTO> basongSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 배송 키워드 검색( 주문번호로 조회)
     */
    @Override
    public List<BasongDTO> basongSelectByOrderNum(int orderNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 배송 키워드 검색(송장번호로 검색)
     */
    @Override
    public List<BasongDTO> basongSelectByInvoiceNum(String basongInvoiceNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 배송 추가
     */
    @Override
    public int basongInsert(BasongDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 배송수정
     */
    @Override
    public int basongUpdate(BasongDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    
    /**
     * 배송삭제
     */
    @Override
    public int basongDelete(int basongNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
