package edu.shoppingMall.dao.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.OrderDetailDAO;
import edu.shoppingMall.dto.OrderDetailDTO;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    private static OrderDetailDAOImpl detailDAO = new OrderDetailDAOImpl();
    
    public static OrderDetailDAOImpl getInstance() {
        return detailDAO;
    }
    
    /**
     * 주문상세 전체조회
     */
    @Override
    public List<OrderDetailDTO> orderDetailSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 주문상세 유저아이디로 조회
     */
    @Override
    public List<OrderDetailDTO> orderDetailSelectByUserId(String userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 주문상세 주문 번호로 조회
     */
    @Override
    public OrderDetailDTO orderDetailSelectByOrderNum(int orderNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 주문상세 추가
     */
    @Override
    public int orderDetailInsert(OrderDetailDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    /**
     * 주문상세 수정
     */
    @Override
    public int orderDetailUpdate(OrderDetailDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 주문상세 삭제
     */
    @Override
    public int orderDetailDelete(int orderDetailNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
