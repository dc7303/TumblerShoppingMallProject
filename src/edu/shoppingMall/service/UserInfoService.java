package edu.shoppingMall.service;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.UserInfoDTO;


/**
 * �������� Service Interface�Դϴ�.
 * ������ ������ �� �������� ����ϴ� ���μ����Դϴ�.
 * ���� �ּ����� ����ǥ�ð� �Ǿ������� Ȯ���Ͻð� ����Ͻø� �˴ϴ�.
 * @author mark
 *
 */
public interface UserInfoService {
    
    /**
     * ȸ����ü ��ȸ(Admin ����)
     */
    List<UserInfoDTO> userSelectAll() throws SQLException;
    
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
