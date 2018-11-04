package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.OrderDAO;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.util.DBUtil;

public class OrderDAOImpl implements OrderDAO {
    private static OrderDAOImpl daoImpl = new OrderDAOImpl();
    
    public static OrderDAOImpl getInstance() {
        return daoImpl;
    }
    
    /**
     * 주문 전체 조회
     * @return
     * @throws SQLException
     */
    @Override
    public List<OrderDTO> orderSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 주문 생성
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int orderInsert(OrderDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into orderInfo values (order_num, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int result = 0;
        System.out.println("dao연결");
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dto.getOrderProductNum());
            ps.setString(2, dto.getOrderUserId());
            ps.setInt(3, dto.getBasongNum());
            ps.setInt(4, dto.getOrderQuantity());
            ps.setString(5, dto.getOrderOption());
            ps.setString(6, dto.getBasongAddr());
            ps.setString(7, dto.getBasongPhone());
            ps.setString(8, dto.getComent());
            ps.setString(9, dto.getPayment());
            
            result = ps.executeUpdate();
        }finally {
            DBUtil.dbClose(ps, con);
        }
        return result;
    }

    /**
     * 주문내역 수정
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int orderUpdate(OrderDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 주문 취소(삭제)
     * @param orderNum
     * @return
     * @throws SQLException
     */
    @Override
    public int orderDelete(int orderNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
