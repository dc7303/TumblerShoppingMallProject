package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.UserInfoDAO;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.util.DBUtil;

public class UserInfoDAOImpl implements UserInfoDAO {
    private static UserInfoDAOImpl daoImpl = new UserInfoDAOImpl();
    
    public static UserInfoDAOImpl getInstance() {
        return daoImpl;
    }
    /**
     * ���� ��ü�˻�(Admin ����)
     */
    @Override
    public List<UserInfoDTO> userSelectAllController() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ���� Ű���� �˻�(Admin ����)
     */
    @Override
    public List<UserInfoDTO> userSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ȸ������
     */
    @Override
    public int signUp(UserInfoDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * �α���
     */
    @Override
    public boolean signIn(String id, String pwd) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from shoppinguser where user_id = ? and user_pwd = ?";
        boolean result = false;
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            
            result = rs.next();
        } finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return result;
    }

    /**
     * ȸ������ ����
     */
    @Override
    public int userUpdate(UserInfoDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * ȸ�� Ż��
     */
    @Override
    public int userDelete(UserInfoDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
