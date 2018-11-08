package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.dto.OrderDetailDTO;

public interface OrderDetailDAO {
    /**
     * 주문 상세 조회
     */
    List<OrderDetailDTO> orderDetailSelectAll() throws SQLException;
    
    /**
     * 주문 상세 키워드 (유저 ID 검색 )
     */
    List<OrderDetailDTO> orderDetailSelectByUserId(String userId) throws SQLException;
    
    /**
     * 주문 상세 키워드 ( 주문 번호 검색 )
     */
    OrderDetailDTO orderDetailSelectByOrderNum(int orderNum) throws SQLException;
    
    /**
     * 주문 상세 추가
     */
    int orderDetailInsert(OrderDetailDTO dto) throws SQLException;
    
    /**
     * 주문 상세 수정
     */
    int orderDetailUpdate(OrderDetailDTO dto) throws SQLException;
    
    /**
     * 주문 상세 삭제(주문번호로 삭제)
     */
    int orderDetailDelete(int orderNum) throws SQLException;
}
