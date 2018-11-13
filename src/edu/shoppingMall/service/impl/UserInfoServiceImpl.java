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
     * ���� ��ü�˻�(Admin ����)
     */
    @Override
    public List<UserInfoDTO> userSelectAll() throws SQLException {
        List<UserInfoDTO> list = daoImple.userSelectAll();
        if(list == null) {
            throw new SQLException("��ϵ� ������ �����ϴ�.");
        }
        return list;
    }
    
    /**
     * ���� Ű���� �˻� (Admin ����)
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
        int result = daoImple.signUp(dto);
        if(result == 0) {
            throw new SQLException("ȸ�����Կ� �����߽��ϴ�.");
        }
        return result;
    }

    /**
     * �α���
     */
    @Override
    public UserInfoDTO signIn(String id, String pwd) throws SQLException {
        UserInfoDTO dto = daoImple.signIn(id, pwd);
        if(dto == null) {
            throw new SQLException("������ ��ġ���� �ʽ��ϴ�. �ٽ� �α������ּ���.");
        }
        return dto;
    }

    /**
     * ȸ������ ����
     */
    @Override
    public int userUpdate(UserInfoDTO dto) throws SQLException {
        int result = daoImple.userUpdate(dto);
        if(result == 0) {
            throw new SQLException("ȸ�� ������ ������ �� �����ϴ�.");
        }
        return result;
    }

    /**
     * ȸ��Ż��
     */
    @Override
    public int userDelete(UserInfoDTO dto) throws SQLException {
    	   int result = daoImple.userDelete(dto);
           if(result == 0) {
               throw new SQLException("ȸ�� ������ Ż���� �� �����ϴ�.");
           }
           return result;
    }

}
