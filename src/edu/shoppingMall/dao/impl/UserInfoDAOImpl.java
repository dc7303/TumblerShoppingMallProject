package edu.shoppingMall.dao.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.UserInfoDAO;
import edu.shoppingMall.dto.UserInfoDTO;

public class UserInfoDAOImpl implements UserInfoDAO {
    
    /**
     * ���� ��ü�˻�(Admin ����)
     */
    @Override
    public List<UserInfoDTO> userSelectAllController() throws SQLException {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * �α���
     */
    @Override
    public boolean signIn(String id, String pwd) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * ȸ������ ����
     */
    @Override
    public int userUpdate(UserInfoDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
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
