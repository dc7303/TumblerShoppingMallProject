package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.OrderDTO;


/**
 * 주문DAO 영역입니다. 유저영역 프로세서입니다.
 * 나중에 장바구니와 구현 시 수정될 수 있는 부분임으로 참고 부탁드립니다.
 * @author mark
 *
 */
public interface OrderDAO {
    
    /**
     * 주문 조회
     */
    List<OrderDTO> orderSelectAll() throws SQLException;
    
    /**
     * 주문 키워드 검색 (ID 조회)
     */
    List<OrderDTO> orderSelectByUserId(String userId, String basongFlag) throws SQLException;
    
    /**
     * 주문 키워드 검색 (주문번호 조회)
     */
    OrderDTO orderSelectByOrderNum(int orderNum) throws SQLException;
    
    
    /**
     * 시퀀스값 가져오기
     */
    public int orderSeqSearch() throws SQLException;
    
    /**
     * 주문 추가
     */
    int orderInsert(OrderDTO dto) throws SQLException;
    
    /**
     * 주문 수정
     */
    int orderUpdate(int orderNum, int price) throws SQLException;
    
    /**
     * 주문 취소
     */
    int orderDelete(int orderNum) throws SQLException;
    
    
}
