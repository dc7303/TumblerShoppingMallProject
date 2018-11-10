package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.QnABoardDAO;
import edu.shoppingMall.dao.impl.QnABoardDAOImpl;
import edu.shoppingMall.dto.QnABoardDTO;
import edu.shoppingMall.service.QnABoardService;

public class QnABoardServiceImpl implements QnABoardService {
	QnABoardDAO dao = new QnABoardDAOImpl();

	@Override
	public List<QnABoardDTO> qnaBoardSelectAll() throws SQLException {
	
		List<QnABoardDTO> list = dao.qnaBoardSelectAll();
		return list;
	}

	@Override
	public List<QnABoardDTO> qnaBoardSelectBySearch(String keyType, String keyWord) throws SQLException {
			List<QnABoardDTO> list = dao.qnaBoardSelectBySearch(keyType, keyWord);
		return list;
	}

	@Override
	public int qnaBoardInsert(QnABoardDTO dto) throws SQLException {
	  int result = dao.qnaBoardInsert(dto);
		return result;
	}

	public int qnaBoardUpdate(QnABoardDTO dto) throws SQLException {
		int result = dao.qnaBoardUpdate(dto);
		System.out.println("serviceImpl"+dto.getQnaBoardContent());
		return result;
	}

	@Override
	public int qnaBoardDelete(String qnaBoardUserId) throws SQLException {
	
		int result = dao.qnaBoardDelete( qnaBoardUserId);
	    
		return result;
	}

	@Override
	public QnABoardDTO qnaBoardSelectByNo(int no) throws SQLException {
		return dao.qnaBoardSelectByNo(no);
		
		
		
	}
		
		
	
}
