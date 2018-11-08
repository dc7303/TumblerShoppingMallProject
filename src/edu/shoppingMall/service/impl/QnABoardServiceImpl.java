package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.QnABoardDTO;
import edu.shoppingMall.service.QnABoardService;

public class QnABoardServiceImpl implements QnABoardService {
    private static QnABoardServiceImpl service = new QnABoardServiceImpl();
    
    public static QnABoardServiceImpl getInstance() {
        return service;
    }
    
    /**
     * Q&A 게시판 전체조회
     * @return
     * @throws SQLException
     */
    @Override
    public List<QnABoardDTO> qnaBoardSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Q&A 게시판 키워드 검색
     * @param keyType
     * @param keyWord
     * @return
     * @throws SQLException
     */
    @Override
    public List<QnABoardDTO> qnaBoardSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Q&A 게시판 추가
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int qnaBoardInsert(QnABoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Q&A 게시판 수정
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int qnaBoardUpdate(QnABoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Q&A 게시판 삭제
     * @param qnaBoardNum
     * @return
     * @throws SQLException
     */
    @Override
    public int qnaBoardDelete(String qnaBoardNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
