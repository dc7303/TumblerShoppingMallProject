package edu.shoppingMall.dao.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.BasongDAO;
import edu.shoppingMall.dto.BasongDTO;

public class BasongDAOImpl implements BasongDAO {
    private static BasongDAOImpl basongDAO = new BasongDAOImpl();
    
    public static BasongDAOImpl getInstance() {
        return basongDAO;
    }
    
    /**
     * ��� ��ü��ȸ
     */
    @Override
    public List<BasongDTO> basongSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��� Ű���� �˻�( �ֹ���ȣ�� ��ȸ)
     */
    @Override
    public List<BasongDTO> basongSelectByOrderNum(int orderNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��� Ű���� �˻�(�����ȣ�� �˻�)
     */
    @Override
    public List<BasongDTO> basongSelectByInvoiceNum(String basongInvoiceNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��� �߰�
     */
    @Override
    public int basongInsert(BasongDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * ��ۼ���
     */
    @Override
    public int basongUpdate(BasongDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    
    /**
     * ��ۻ���
     */
    @Override
    public int basongDelete(int basongNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
