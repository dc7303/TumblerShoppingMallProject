package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.NoticeBoardDTO;
import edu.shoppingMall.service.NoticeBoardService;

public class NoticeBoardServiceImpl implements NoticeBoardService {
    private static NoticeBoardServiceImpl service = new NoticeBoardServiceImpl();
    
    public static NoticeBoardServiceImpl getInstance () {
        return service;
    }
    
    /**
     * �������� ��ü��ȸ
     */
    @Override
    public List<NoticeBoardDTO> noticeBoardSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * �������� Ű���� �˻�
     */
    @Override
    public List<NoticeBoardDTO> noticeBoardSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * �������� �߰�
     */
    @Override
    public int noticeBoardInsert(NoticeBoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * �������� ����
     */
    @Override
    public int noticeBoardUpdate(NoticeBoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * �������� ����
     */
    @Override
    public int noticeBoardDelete(String NoticeBoardNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
