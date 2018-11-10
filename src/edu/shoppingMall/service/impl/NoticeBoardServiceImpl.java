package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.NoticeDAO;
import edu.shoppingMall.dao.impl.NoticeDAOImpl;
import edu.shoppingMall.dto.NoticeBoardDTO;
import edu.shoppingMall.service.NoticeBoardService;

public class NoticeBoardServiceImpl implements NoticeBoardService {
    private NoticeDAO noticedao = new NoticeDAOImpl().getInstance(); 
	private static NoticeBoardServiceImpl service = new NoticeBoardServiceImpl();
    

    
    public static NoticeBoardServiceImpl getInstance () {
        return service;
    }
    
    /**
     * �������� ��ü��ȸ
     */
    @Override
    public List<NoticeBoardDTO> noticeBoardSelectAll() throws SQLException {
    	List<NoticeBoardDTO> list = noticedao.noticeBoardSelectAll();
    	if(list==null)throw new SQLException("notice�˻������ �����ϴ�.");
    	return list;
    }

    /**
     * �������� Ű���� �˻� ����
     */
  /*  @Override
    public List<NoticeBoardDTO> noticeBoardSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
*/
    /**
     * �������� �߰�
     */
    @Override
    public int noticeBoardInsert(NoticeBoardDTO dto) throws SQLException {
    	int result = noticedao.noticeBoardInsert(dto);
		if(result==0)throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
		return result;
		
	}
    
      /**
     * �������� ����
     */
    @Override
    public int noticeBoardUpdate(NoticeBoardDTO dto) throws SQLException {
    	int result = noticedao.noticeBoardUpdate(dto);
		if(result==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		return result;
    }

    /**
     * �������� ����
     */
    @Override
    public int noticeBoardDelete(int NoticeBoardNum) throws SQLException {
    	int result = noticedao.noticeBoardDelete(NoticeBoardNum);
		if(result == 0)throw new SQLException("�˻��� ���ڵ尡 �����ϴ�.");
		return result;
    }

	
    /**
     * ���ڻ��׹�ȣ�� �˻� �߰�
     * 
     */
    @Override
	public NoticeBoardDTO selectByNoticeNum(int NoticeBoardNum) throws SQLException {
    	 //�۹�ȣ�� �ش��ϴ� �Խù� �˻�
		NoticeBoardDTO dto =  noticedao.selectByNoticeNum(NoticeBoardNum);
		if(dto==null)throw new SQLException(NoticeBoardNum+" �ش��ϴ� ���������̾����ϴ�.");
		
		return dto;
	}
    
    
    
}
