package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public List<UserInfoDTO> userSelectAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from shoppinguser";
        List<UserInfoDTO> list = new ArrayList<>();
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                list.add(new UserInfoDTO());
            }
        }finally {
            
        }
        return list;
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
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into ????? values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
     * �α���
     */
    @Override
    public UserInfoDTO signIn(String id, String pwd) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from ??? where user_id = ? and user_pwd = ?";
        UserInfoDTO dto = null;
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                dto = new UserInfoDTO();
            }
        } finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return dto;
    }

    /**
     * ȸ������ ����
     */
    @Override
    public int userUpdate(UserInfoDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update ??? set user_pwd = ?, name = ?, birth = ?, addr = ?, email = ? where user_id = ?";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getUserPwd());
            ps.setString(2, dto.getUserName());
            ps.setString(3, dto.getUserBirth());
            ps.setString(4, dto.getUserAddr());
            ps.setString(5, dto.getUserEmail());
            ps.setString(6, dto.getUserId());
            
            result = ps.executeUpdate();
        }finally {
            DBUtil.dbClose(ps, con);
        }
        
        return result;
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
