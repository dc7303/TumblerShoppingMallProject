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
     * 유저 전체검색(Admin 영역)
     */
    @Override
    public List<UserInfoDTO> userSelectAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from tb_user";
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
        String sql = "insert into tb_user values (?, ?, ?, ?, ?, ?, ?, 0, 0, sysdate)";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getUserId());
            ps.setString(2, dto.getUserName());
            ps.setString(3, dto.getUserPwd());
            ps.setString(4, dto.getUserBirth());
            ps.setString(5, dto.getUserPhone());
            ps.setString(6, dto.getUserAddr());
            ps.setString(7, dto.getUserEmail());
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
    public UserInfoDTO signIn(String id, String pwd) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from tb_user where userid = ? and pwd = ? and flag = 0";
        UserInfoDTO dto = null;
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                dto = new UserInfoDTO(rs.getString("userid"),rs.getString("name"),rs.getString("pwd"),rs.getString("birth"),rs.getString("phone"),rs.getString("addr"),rs.getString("email"),rs.getInt("manger"),rs.getInt("flag"),rs.getString("regdt"));
            }
        } finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return dto;
    }

    /**
     * 회원정보 수정
     */
    @Override
    public int userUpdate(UserInfoDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update tb_user set pwd = ?, name = ?, birth = ?,phone = ? , addr = ?, email = ? where userid = ?";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getUserPwd());
            ps.setString(2, dto.getUserName());
            ps.setString(3, dto.getUserBirth());
            ps.setString(4, dto.getUserPhone());
            ps.setString(5, dto.getUserAddr());
            ps.setString(6, dto.getUserEmail());
            ps.setString(7, dto.getUserId());
            
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
    	Connection con = null;
        PreparedStatement ps = null;
        //String sql = "delete tb_user where userid = ? and pwd =?";
        String sql = "update tb_user set flag=? where userid = ? and pwd =?";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2, dto.getUserId());
            ps.setString(3	, dto.getUserPwd());
            
            result = ps.executeUpdate();
        }finally {
            DBUtil.dbClose(ps, con);
        }
        
        return result;
    }

}
