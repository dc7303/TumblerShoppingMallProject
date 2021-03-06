package edu.shoppingMall.service;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.UserInfoDTO;


/**
 * 유저정보 Service Interface입니다.
 * 유저와 관리자 두 영역에서 사용하는 프로세서입니다.
 * 이하 주석에서 영역표시가 되어있으니 확인하시고 사용하시면 됩니다.
 * @author mark
 *
 */
public interface UserInfoService {
    
    /**
     * 회원전체 조회(Admin 영역)
     */
    List<UserInfoDTO> userSelectAll() throws SQLException;

    /**
     * 회원 부분 검색(Admin 영역)
     */
    List<UserInfoDTO> userSelectBySearch(String keyType, String keyWord) throws SQLException;

    /**
     * 회원가입
     */
    int signUp(UserInfoDTO dto) throws SQLException;

    /**
     * 로그인
     */
    UserInfoDTO signIn(String id, String pwd) throws SQLException;

    /**
     * 회원정보 수정
     */
    int userUpdate(UserInfoDTO dto) throws SQLException;

    /**
     * 회원탈퇴
     */
    int userDelete(UserInfoDTO dto) throws SQLException;
    
}
