package edu.shoppingMall.service;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.NoticeBoardDTO;

/**
 * 공지사항 게시판 Service Interface입니다.
 * 관리자 영역에서 사용하는 프로세서입니다.
 * @author mark
 *
 */
public interface NoticeBoardService {
    
    /**
     * 공지사항 전체검색
     */
    List<NoticeBoardDTO> noticeBoardSelectAll() throws SQLException;

    /**
     * 공지사항 부분검색 삭제
     */
 /*   List<NoticeBoardDTO> noticeBoardSelectBySearch(String keyType, String keyWord) throws SQLException;*/

    /**
     * 공지사항 추가
     */
    int noticeBoardInsert(NoticeBoardDTO dto) throws SQLException;

    /**
     * 공지사항 수정
     */
    int noticeBoardUpdate(NoticeBoardDTO dto) throws SQLException;

    /**
     * 공지사항 삭제
     */
    int noticeBoardDelete(int NoticeBoardNum) throws SQLException;
    
   /**
    * 공자사항번호로 검색 추가
    * 
    */
    NoticeBoardDTO selectByNoticeNum(int NoticeBoardNum)throws SQLException;
    
}
