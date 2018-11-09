package edu.shoppingMall.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.shoppingMall.dto.BasongDTO;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.dto.OrderDetailDTO;


/**
 * 주문 관련 Service Interface입니다.
 * 유저 영역에서 사용하는 프로세서입니다.
 * @author mark
 *
 */
public interface OrderService {
    
    /**
     * 주문 조회(BasongDTO, OrderDetailDTO 포함한 OrderDTO를 리턴한다
     */
    List<OrderDTO> orderSelectAll() throws SQLException;
    
    /**
     * 주문 키워드 검색 (ID 조회, BasongDTO, OrderDetailDTO 포함한 OrderDTO를 리턴한다)
     * ID를 파라미터로 받아 주문상세, 주문 각각 ID로 조회 가능한 DAO 메소드를 사용할 수 있다.
     */
    List<OrderDTO> orderSelectByUserId(String userId) throws SQLException;
    
    /**
     * 주문 키워드 검색 (주문번호 조회)
     * 주문번호를 파라미터로 받아 배송, 주문상세, 주문 각각 주문번호로 조회 가능한 DAO 메소드를 사용할 수 있다.
     */
    OrderDTO orderSelectByOrderNum(int orderNum) throws SQLException;
    
    /**
     * 주문 추가( BasongDTO, OrderDetailDTO 포함한 OrderDTO를 받는다)
     */
    int orderInsert(OrderDTO orderDTO) throws SQLException;
    
    /**
     * 장바구니에서 주문
     * UserId를 받아 장바구니 조회 - > 주문 테이블 생성 - > 시퀀스 조회 - > 반복문으로 디테일과 배송 테이블 생성
     */
    int orderInsertByBasket(String userId, String comment, BasongDTO basongDTO) throws SQLException;
    
    /**
     * 주문 수정
     */
    int orderUpdate(OrderDTO dto) throws SQLException;
    
    /**
     * 주문 취소
     */
    int orderDelete(int orderNum) throws SQLException;
    
    
}
