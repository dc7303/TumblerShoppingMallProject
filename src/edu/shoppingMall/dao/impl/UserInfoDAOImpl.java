package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.crypto.provider.AESParameters;

import edu.shoppingMall.dao.UserInfoDAO;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.util.DBUtil;

public class UserInfoDAOImpl implements UserInfoDAO {
    private static UserInfoDAOImpl daoImpl = new UserInfoDAOImpl();
    
    public static UserInfoDAOImpl getInstance() {
        return daoImpl;
    }
    /**
     * 유저 전체검색(Admin 영역)
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
                list.add(new UserInfoDTO(rs.getString("user_id"), rs.getString("user_pwd"), 
                        rs.getString("name"), rs.getString("birth"), rs.getString("addr"),
                        rs.getString("email"), rs.getString("is_admin")));
            }
        }finally {
            
        }
        return list;
    }

    /**
     * 유저 키워드 검색(Admin 영역)
     */
    @Override
    public List<UserInfoDTO> userSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 회원가입
     */
    @Override
    public int signUp(UserInfoDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into shoppinguser values (?, ?, ?, ?, ?, ?, ?)";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getUserId());
            ps.setString(2, dto.getUserPwd());
            ps.setString(3, dto.getUserName());
            ps.setString(4, dto.getUserBirth());
            ps.setString(5, dto.getUserAddr());
            ps.setString(6, dto.getUserEmail());
            ps.setString(7, "user");
            
            result = ps.executeUpdate();
        }finally {
            DBUtil.dbClose(ps, con);
        }
        
        return result;
    }

    /**
     * 로그인
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
     * 회원정보 수정
     */
    @Override
    public int userUpdate(UserInfoDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update shoppinguser set user_pwd = ?, name = ?, birth = ?, addr = ?, email = ? where user_id = ?";
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
     * 회원 탈퇴
     */
    @Override
    public int userDelete(UserInfoDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
