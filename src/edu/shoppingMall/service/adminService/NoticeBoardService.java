package edu.shoppingMall.service.adminService;

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
     * 게시물조회
     */
    List<NoticeBoardDTO> noticeBoardSelectAll() throws SQLException;
    
    /**
     * 게시물키워드 조회
     */
    List<NoticeBoardDTO> noticeBoardSelectBySearch(String keyType, String keyWord) throws SQLException;
    
    /**
     * 게시물추가
     */
    int noticeBoardInsert(NoticeBoardDTO dto) throws SQLException;
    
    /**
     * 게시물수정
     */
    int noticeBoardUpdate(NoticeBoardDTO dto) throws SQLException;
    
    /**
     * 게시물삭제
     */
    int noticeBoardDelete(int noticeBoardNum) throws SQLException;
}
