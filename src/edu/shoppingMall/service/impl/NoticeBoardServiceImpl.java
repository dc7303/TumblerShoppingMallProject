package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.NoticeDAO;
import edu.shoppingMall.dao.impl.NoticeDAOImpl;
import edu.shoppingMall.dto.NoticeBoardDTO;
import edu.shoppingMall.service.NoticeBoardService;

public class NoticeBoardServiceImpl implements NoticeBoardService {
    private static NoticeBoardServiceImpl service = new NoticeBoardServiceImpl();
    
    public static NoticeDAO noticedao = new NoticeDAOImpl();
    
    public static NoticeBoardServiceImpl getInstance () {
        return service;
    }
    
    /**
     * 공지사항 전체조회
     */
    @Override
    public List<NoticeBoardDTO> noticeBoardSelectAll() throws SQLException {
    	List<NoticeBoardDTO> list = noticedao.noticeBoardSelectAll();
		return list;
    }

    /**
     * 공지사항 키워드 검색 삭제
     */
  /*  @Override
    public List<NoticeBoardDTO> noticeBoardSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
*/
    /**
     * 공지사항 추가
     */
    @Override
    public int noticeBoardInsert(NoticeBoardDTO dto) throws SQLException {
    	int result = noticedao.noticeBoardInsert(dto);
		if(result==0)throw new SQLException("등록되지 않았습니다.");
		return result;
		
	}
    
    
    
    

    /**
     * 공지사항 수정
     */
    @Override
    public int noticeBoardUpdate(NoticeBoardDTO dto) throws SQLException {
    	int re = noticedao.noticeBoardUpdate(dto);
		if(re==0)throw new SQLException("수정되지 않았습니다.");
		return re;
    }

    /**
     * 공지사항 삭제
     */
    @Override
    public int noticeBoardDelete(int NoticeBoardNum) throws SQLException {
    	int result = noticedao.noticeBoardDelete(NoticeBoardNum);
		if(result == 0)
			throw new SQLException("검색된 레코드가 없습니다.");
		
		
		return result;
    }

	
    /**
     * 공자사항번호로 검색 추가
     * 
     */
    @Override
	public NoticeBoardDTO selectByNoticeNum(int NoticeBoardNum) throws SQLException {
    	 //글번호에 해당하는 게시물 검색
		NoticeBoardDTO dto =  noticedao.selectByNoticeNum(NoticeBoardNum);
		if(dto==null)throw new SQLException(NoticeBoardNum+" 해당하는 공지상항이없습니다.");
		
		return dto;
	}
    
    
    
}
