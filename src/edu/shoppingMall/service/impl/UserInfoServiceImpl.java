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
        if(list == null) {
            throw new SQLException("등록된 유저가 없습니다.");
        }
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
        if(result == 0) {
            throw new SQLException("회원가입에 실패했습니다.");
        }
        return result;
    }

    /**
     * 로그인
     */
    @Override
    public UserInfoDTO signIn(String id, String pwd) throws SQLException {
        UserInfoDTO dto = daoImple.signIn(id, pwd);
        if(dto == null) {
            throw new SQLException("정보가 일치하지 않습니다. 다시 로그인해주세요.");
        }
        return dto;
    }

    /**
     * 회원정보 수정
     */
    @Override
    public int userUpdate(UserInfoDTO dto) throws SQLException {
        int result = daoImple.userUpdate(dto);
        if(result == 0) {
            throw new SQLException("회원 정보를 수정할 수 없습니다.");
        }
        return result;
    }

    /**
     * 회원탈퇴
     */
    @Override
    public int userDelete(UserInfoDTO dto) throws SQLException {
    	   int result = daoImple.userDelete(dto);
           if(result == 0) {
               throw new SQLException("회원 정보를 탈퇴할 수 없습니다.");
           }
           return result;
    }

}
