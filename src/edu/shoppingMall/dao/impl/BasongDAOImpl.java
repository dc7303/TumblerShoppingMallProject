package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.BasongDAO;
import edu.shoppingMall.dto.BasongDTO;
import edu.shoppingMall.util.DBUtil;

public class BasongDAOImpl implements BasongDAO {
    private static BasongDAOImpl basongDAO = new BasongDAOImpl();
    
    public static BasongDAOImpl getInstance() {
        return basongDAO;
    }
    
    /**
     * ��� ��ü��ȸ
     */
    @Override
    public List<BasongDTO> basongSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��� Ű���� �˻�( �ֹ���ȣ�� ��ȸ)
     */
    @Override
    public List<BasongDTO> basongSelectByOrderNum(int orderNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��� Ű���� �˻�(�����ȣ�� �˻�)
     */
    @Override
    public List<BasongDTO> basongSelectByInvoiceNum(String basongInvoiceNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��� �߰�
     */
    @Override
    public int basongInsert(BasongDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into tb_delivery values (delivery_seq.nextval, ?, ?, ?, ?, sysdate, ?, 0)";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getBasongCompany());
            ps.setString(2, dto.getBasongInvoiceNum());
            ps.setString(3, dto.getBasongAddr());
            ps.setString(4, dto.getBasongPhone());
            ps.setInt(5, dto.getOrderNum());
            
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
     * ��ۼ���
     */
    @Override
    public int basongUpdate(BasongDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    
    /**
     * ��ۻ���(�ֹ���ȣ�� ����)
     */
    @Override
    public int basongDelete(int orderNum) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from tb_delivery where ono = ?";
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
