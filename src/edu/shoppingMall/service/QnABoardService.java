package edu.shoppingMall.service;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.QnABoardDTO;

/**
 * QnA게시판 Service Interface입니다.
 * 유저와 관리자 두 영역에서 사용하는 프로세서입니다.
 * @author mark
 *
 */
public interface QnABoardService {
    
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
    int qnaBoardDelete(int qno) throws SQLException;
    
    /**
     * 게시글 조회
     */
    QnABoardDTO qnaBoardSelectByNo(int no) throws SQLException;
}
