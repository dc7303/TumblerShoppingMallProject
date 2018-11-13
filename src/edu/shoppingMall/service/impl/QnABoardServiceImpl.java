package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.QnABoardDAO;
import edu.shoppingMall.dao.impl.QnABoardDAOImpl;
import edu.shoppingMall.dto.QnABoardDTO;
import edu.shoppingMall.service.QnABoardService;

public class QnABoardServiceImpl implements QnABoardService {
	QnABoardDAO dao = QnABoardDAOImpl.getInstance();
    private static QnABoardServiceImpl service = new QnABoardServiceImpl();
    
    public static QnABoardServiceImpl getInstance() {
        return service;
    }


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
	  if(result == 0) {
	      throw new SQLException("게시물 등록에 실패했습니다.");
	  }
		return result;
	}

	public int qnaBoardUpdate(QnABoardDTO dto) throws SQLException {
		int result = dao.qnaBoardUpdate(dto);
		if(result == 0) {
	          throw new SQLException("게시물 수정에 실패했습니다.");
	      }
		return result;
	}

	@Override
	public int qnaBoardDelete(int qno) throws SQLException {
	
		int result = dao.qnaBoardDelete(qno);
		if(result == 0) {
	          throw new SQLException("게시물 삭제에 실패했습니다.");
	      }
		return result;
	}

	@Override
	public QnABoardDTO qnaBoardSelectByNo(int no) throws SQLException {
		return dao.qnaBoardSelectByNo(no);
	}
		
		
	
}
