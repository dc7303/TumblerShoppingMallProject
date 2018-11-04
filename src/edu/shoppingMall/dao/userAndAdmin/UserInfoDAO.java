package edu.shoppingMall.dao.userAndAdmin;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.UserInfoDTO;

/**
 * �������� DAO�Դϴ�. ������ ������ �� �������� ����ϸ�, 
 * �� ������ �ּ����� ǥ�õǾ��־� Ȯ�� �� ����Ͻø� �˴ϴ�.
 * @author mark
 *
 */
public interface UserInfoDAO {

    /**
     * ȸ����ü ��ȸ(Admin ����)
     */
    List<UserInfoDTO> userSelectAllController() throws SQLException;

    /**
     * ȸ�� �κ� �˻�(Admin ����)
     */
    List<UserInfoDTO> userSelectBySearch(String keyType, String keyWord) throws SQLException;

    /**
     * ȸ�� ���� ����(�������� ��� ȸ�� ��¡)
     */

    /**
     * ȸ������
     */
    int signUp(UserInfoDTO dto) throws SQLException;

    /**
     * �α���
     */
    boolean signIn(String id, String pwd) throws SQLException;

    /**
     * ȸ������ ����
     */
    int userUpdate(UserInfoDTO dto) throws SQLException;

    /**
     * ȸ��Ż��
     */
    int userDelete(UserInfoDTO dto) throws SQLException;

}
