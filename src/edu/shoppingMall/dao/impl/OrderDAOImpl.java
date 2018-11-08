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
     * 주문 키워드 검색 (ID로 검색)
     */
    @Override
    public List<OrderDTO> orderSelectByUserId(String userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 주문 키워드 검색 (주문번호로 검색)
     */
    @Override
    public OrderDTO orderSelectByOrderNum(int orderNum) throws SQLException {
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
        String sql = "insert into tb_order values (order_seq.nextval, ?, sysdate, ?, ?)";
        int result = 0;

        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getOrderUserId());
            ps.setInt(2, dto.getOrderPrice());
            ps.setString(3, dto.getOrderComment());
            
            result = ps.executeUpdate();
        }finally {
            if(result > 0) {
                con.commit();
            }else {
                con.rollback();
            }
            DBUtil.dbClose(ps, con);
        }
        return result;
    }
    
    /**
     * 현재 시퀀스값 가져오기
     * @return
     * @throws SQLException
     */
    public int orderSeqSearch() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select order_seq.currval from dual";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                result = rs.getInt("currval");
            }
        }finally {
            DBUtil.dbClose(rs, ps, con);
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
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from tb_order where ono = ? ";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(sql);
            ps.setInt(1, orderNum);
            
            result = ps.executeUpdate();
        }finally {
            if(result > 0) {
                con.commit();
            }else {
                con.rollback();
            }
            DBUtil.dbClose(ps, con);
        }
        return result;
    }

}
