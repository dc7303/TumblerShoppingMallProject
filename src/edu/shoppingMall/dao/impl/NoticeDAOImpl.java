package edu.shoppingMall.dao.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.NoticeDAO;
import edu.shoppingMall.dto.NoticeBoardDTO;

public class NoticeDAOImpl implements NoticeDAO {
    private static NoticeDAOImpl noticeDAO = new NoticeDAOImpl();
    
    public static NoticeDAOImpl getInstance() {
        return noticeDAO;
    }
    
    
    /**
     * 공지사항 전체 조회
     * @return
     * @throws SQLException
     */
    @Override
    public List<NoticeBoardDTO> noticeBoardSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 공지사항 키워드 검색
     * @param keyType
     * @param keyWord
     * @return
     * @throws SQLException
     */
    @Override
    public List<NoticeBoardDTO> noticeBoardSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 공지사항 추가
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int noticeBoardInsert(NoticeBoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 공지사항 수정
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int noticeBoardUpdate(NoticeBoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 공지사항 삭제
     * @param NoticeBoardNum
     * @return
     * @throws SQLException
     */
    @Override
    public int noticeBoardDelete(String NoticeBoardNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
