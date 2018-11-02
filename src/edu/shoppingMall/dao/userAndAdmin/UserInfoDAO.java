package edu.shoppingMall.dao.userAndAdmin;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.UserInfoDTO;

/**
 * 유저정보 DAO입니다. 유저와 관리자 두 영역에서 사용하며, 
 * 각 영역이 주석으로 표시되어있어 확인 후 사용하시면 됩니다.
 * @author mark
 *
 */
public interface UserInfoDAO {

    /**
     * 회원전체 조회(Admin 영역)
     */
    List<UserInfoDTO> userSelectAllController() throws SQLException;

    /**
     * 회원 부분 검색(Admin 영역)
     */
    List<UserInfoDTO> userSelectBySearch(String keyType, String keyWord) throws SQLException;

    /**
     * 회원 정보 수정(부적절한 사용 회원 응징)
     */

    /**
     * 회원가입
     */
    int signUp(UserInfoDTO dto) throws SQLException;

    /**
     * 로그인
     */
    boolean signIn(String id, String pwd) throws SQLException;

    /**
     * 회원정보 수정
     */
    int userUpdate(UserInfoDTO dto) throws SQLException;

    /**
     * 회원탈퇴
     */
    int userDelete(UserInfoDTO dto) throws SQLException;

}
