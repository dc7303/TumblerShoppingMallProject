package edu.shoppingMall.dao.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.QnABoardDAO;
import edu.shoppingMall.dto.QnABoardDTO;

public class QnABoardDAOImpl implements QnABoardDAO {
    private static QnABoardDAOImpl qnaDAO = new QnABoardDAOImpl();
    
    public static QnABoardDAOImpl getInstance() {
        return qnaDAO;
    }
    
    /**
     * Q&A �Խ��� ��ü��ȸ
     */
    @Override
    public List<QnABoardDTO> qnaBoardSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * Q&A �Խ��� Ű���� �˻�
     */
    @Override
    public List<QnABoardDTO> qnaBoardSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Q&A �Խ��� �߰�
     */
    @Override
    public int qnaBoardInsert(QnABoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Q&A �Խ��� ����
     */
    @Override
    public int qnaBoardUpdate(QnABoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Q&A �Խ��� ����
     */
    @Override
    public int qnaBoardDelete(String qnaBoardNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
