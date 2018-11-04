package edu.shoppingMall.dao.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.UserInfoDAO;
import edu.shoppingMall.dto.UserInfoDTO;

public class UserInfoDAOImpl implements UserInfoDAO {
    
    /**
     * 유저 전체검색(Admin 영역)
     */
    @Override
    public List<UserInfoDTO> userSelectAllController() throws SQLException {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 로그인
     */
    @Override
    public boolean signIn(String id, String pwd) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * 회원정보 수정
     */
    @Override
    public int userUpdate(UserInfoDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
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
