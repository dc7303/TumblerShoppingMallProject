package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.NoticeBoardDTO;

/**
 * QnA 게시판 관리 DAO이며, 관리자와 유저 두 영역에서 사용하는 프로세서입니다. QnABoardDTO 변수 중
 * qnaBoardChildNum을 사용해서 어느 글의 댓글인지 설정합니다.
 * 
 * @author mark
 */
public interface NoticeDAO {

    /**
     * 게시글 전체검색
     */
    List<NoticeBoardDTO> noticeBoardSelectAll() throws SQLException;

    /**
     * 게시글 부분검색--> 삭제
     */
/*    List<NoticeBoardDTO> noticeBoardSelectBySearch(String keyType, String keyWord) throws SQLException;
*/
    /**
     * 게시글 추가
     */
    int noticeBoardInsert(NoticeBoardDTO dto) throws SQLException;

    /**
     * 게시글 수정
     */
    int noticeBoardUpdate(NoticeBoardDTO dto) throws SQLException;

    /**
     * 게시글 삭제
     */
    int noticeBoardDelete(int NoticeBoardNum) throws SQLException;

    /**
     * 공지번호로 부분검색 추가 
     * 
     */
    NoticeBoardDTO selectByNoticeNum(int NoticeBoardNum) throws SQLException;
}
