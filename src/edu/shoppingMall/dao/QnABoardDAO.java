package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.QnABoardDTO;


/**
 * QnA 게시판 관리 DAO이며, 관리자와 유저 두 영역에서 사용하는 프로세서입니다.
 * QnABoardDTO 변수 중 qnaBoardChildNum을 사용해서 어느 글의 댓글인지 설정합니다.
 * @author mark
 *
 */
public interface QnABoardDAO {
    
    /**
     * 게시글 전체검색
     */
    List<QnABoardDTO> qnaBoardSelectAll() throws SQLException;
    
    /**
     * 게시글 부분검색
     */
    List<QnABoardDTO> qnaBoardSelectBySearch(String keyType, String keyWord) throws SQLException;
    
    /**
     * 게시글 추가
     */
    int qnaBoardInsert(QnABoardDTO dto) throws SQLException;
    
    /**
     * 게시글 수정
     */
    int qnaBoardUpdate(QnABoardDTO dto) throws SQLException;
    
    /**
     * 게시글 삭제
     */
    int qnaBoardDelete(String qnaBoardNum) throws SQLException;
    
    
}
