package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.OrderDetailDAO;
import edu.shoppingMall.dto.OrderDetailDTO;
import edu.shoppingMall.util.DBUtil;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    private static OrderDetailDAOImpl detailDAO = new OrderDetailDAOImpl();
    
    public static OrderDetailDAOImpl getInstance() {
        return detailDAO;
    }
    
    /**
     * �ֹ��� ��ü��ȸ
     */
    @Override
    public List<OrderDetailDTO> orderDetailSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * �ֹ��� �������̵�� ��ȸ
     */
    @Override
    public List<OrderDetailDTO> orderDetailSelectByUserId(String userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * �ֹ��� �ֹ� ��ȣ�� ��ȸ
     */
    @Override
    public OrderDetailDTO orderDetailSelectByOrderNum(int orderNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * �ֹ��� �߰�
     */
    @Override
    public int orderDetailInsert(OrderDetailDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into tb_detail values (detail_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(sql);
            ps.setInt(1, dto.getOrderNum());
            ps.setInt(2, dto.getProductNum());
            ps.setInt(3, dto.getOrderDetailPrice());
            ps.setInt(4, dto.getOrderDetailQuantity());
            ps.setString(5, dto.getOrderDetailOption());
            
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
     * �ֹ��� ����
     */
    @Override
    public int orderDetailUpdate(OrderDetailDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * �ֹ��� ����(�ֹ���ȣ�� ����)
     */
    @Override
    public int orderDetailDelete(int orderNum) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from tb_detail where ono = ?";
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
