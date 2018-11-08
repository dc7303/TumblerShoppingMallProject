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
     * 공지사항 전체조회
     */
    @Override
    public List<NoticeBoardDTO> noticeBoardSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 공지사항 키워드 검색
     */
    @Override
    public List<NoticeBoardDTO> noticeBoardSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 공지사항 추가
     */
    @Override
    public int noticeBoardInsert(NoticeBoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 공지사항 수정
     */
    @Override
    public int noticeBoardUpdate(NoticeBoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 공지사항 삭제
     */
    @Override
    public int noticeBoardDelete(String NoticeBoardNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
