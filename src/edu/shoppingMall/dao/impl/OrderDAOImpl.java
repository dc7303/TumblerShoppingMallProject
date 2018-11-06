package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from ???";
        List<OrderDTO> list = new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new OrderDTO());
                
            }
        }finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return list;
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
        String sql = "insert into ??? values (?, ?, ?, ?, ?, ?)";
        int result = 0;
        
        System.out.println("dao연결");
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
          
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
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update ???? set basong_num = ?, quantity = ?,"
                + " pro_option = ?, basong_addr = ?, basong_phone = ?,"
                + " basong_coment = ?, payment = ? where order_num = ? and pro_num = ? and user_id = ?";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
     
            
            result = ps.executeUpdate();
        }finally {
            DBUtil.dbClose(ps, con);
        }
        
        return result;
    }

    /**
     * 주문 취소(삭제)
     * @param orderNum
     * @return
     * @throws SQLException
     */
    @Override
    public int orderDelete(int orderNum) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from ???? where order_num = ?";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, orderNum);
            
            result = ps.executeUpdate();
        }finally {
            DBUtil.dbClose(ps, con);
        }
        return result;
    }

}
