package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.BasketDTO;

public interface BasketDAO {
    /**
     * 장바구니 전체검색
     * @return
     * @throws SQLException
     */
    List<BasketDTO> basketSelectAll() throws SQLException;
    
    /**
     * 장바구니 키워드 검색 (장바구니 번호로 검색)
     * @return
     * @throws SQLException
     */
    BasketDTO basketSelectByBasketNum(int basketNum) throws SQLException;
    
    /**
     * 장바구니 키워드 검색 (유저 ID로 검색)
     * @return
     * @throws SQLException
     */
    List<BasketDTO> basketSelectByUserId(String userId) throws SQLException;
    
    /**
     * 장바구니 생성
     * @return
     * @throws SQLException
     */
    int basketInsert(BasketDTO dto) throws SQLException;
    
    /**
     * 장바구니 수정
     * @return
     * @throws SQLException
     */
    int basketUpdate(BasketDTO dto) throws SQLException;
    
    /**
     * 장바구니 삭제
     * @param basketNum
     * @return
     * @throws SQLException
     */
    int basketDelete(String userId) throws SQLException;
}
