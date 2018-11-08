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
     * Q&A 게시판 전체조회
     */
    @Override
    public List<QnABoardDTO> qnaBoardSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * Q&A 게시판 키워드 검색
     */
    @Override
    public List<QnABoardDTO> qnaBoardSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Q&A 게시판 추가
     */
    @Override
    public int qnaBoardInsert(QnABoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Q&A 게시판 수정
     */
    @Override
    public int qnaBoardUpdate(QnABoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Q&A 게시판 삭제
     */
    @Override
    public int qnaBoardDelete(String qnaBoardNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
