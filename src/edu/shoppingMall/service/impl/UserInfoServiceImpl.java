package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.UserInfoDAO;
import edu.shoppingMall.dao.impl.UserInfoDAOImpl;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
    private static UserInfoServiceImpl serviceImpl = new UserInfoServiceImpl();
    private UserInfoDAO daoImple = UserInfoDAOImpl.getInstance();
    
    
    public static UserInfoServiceImpl getInstance() {
        return serviceImpl;
    }
    
    /**
     * 유저 전체검색(Admin 영역)
     */
    @Override
    public List<UserInfoDTO> userSelectAll() throws SQLException {
        List<UserInfoDTO> list = daoImple.userSelectAll();
        return list;
    }
    
    /**
     * 유저 키워드 검색 (Admin 영역)
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
        int result = daoImple.signUp(dto);
        return result;
    }

    /**
     * 로그인
     */
    @Override
    public boolean signIn(String id, String pwd) throws SQLException {
        boolean result = daoImple.signIn(id, pwd);
        return result;
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
     * 회원탈퇴
     */
    @Override
    public int userDelete(UserInfoDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
