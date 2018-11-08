package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.BasongDTO;
import edu.shoppingMall.dto.OrderDetailDTO;

public interface BasongDAO {
    /**
     * 배송 전체 조회
     */
    List<BasongDTO> basongSelectAll() throws SQLException;
    
    /**
     * 배송 키워드 검색 (주문번호로 검색)
     */
    List<BasongDTO> basongSelectByOrderNum(int orderNum) throws SQLException;
    
    /**
     * 배송 키워드 검색 (송장번호 검색)
     */
    List<BasongDTO> basongSelectByInvoiceNum(String basongInvoiceNum) throws SQLException;
    
    /**
     * 배송 추가
     */
    int basongInsert(BasongDTO dto) throws SQLException;
    
    /**
     * 배송 수정
     */
    int basongUpdate(BasongDTO dto) throws SQLException;
    
    /**
     * 배송 삭제(주문번호로 삭제)
     */
    int basongDelete(int orderNum) throws SQLException;
}
