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
    * 공지사항 전체검색 페이징처리
    */
   List<NoticeBoardDTO> noticeBoardSelectAll(int startIndex,int endIndex) throws SQLException;
    
    /**
     * 게시글 부분검색
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
     * 공지번호로 부분검색
     * 
     */
    NoticeBoardDTO selectByNoticeNum(int NoticeBoardNum) throws SQLException;
    
    /**
     * 페이징 처리를 위한 Counting
     * select count(*) as totalcount from tb_notice;
     */
    int selectCount() throws SQLException;
}
