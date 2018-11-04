package edu.shoppingMall.service;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.OrderDTO;


/**
 * 주문 관련 Service Interface입니다.
 * 유저 영역에서 사용하는 프로세서입니다.
 * @author mark
 *
 */
public interface OrderService {
    
    /**
     * 주문 조회
     */
    List<OrderDTO> orderSelectAll() throws SQLException;
    
    /**
     * 주문 추가
     */
    int orderInsert(OrderDTO dto) throws SQLException;
    
    /**
     * 주문 수정
     */
    int orderUpdate(OrderDTO dto) throws SQLException;
    
    /**
     * 주문 취소
     */
    int orderDelete(int orderNum) throws SQLException;
    
    
}
