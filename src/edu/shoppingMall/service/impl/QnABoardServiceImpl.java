package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.QnABoardDTO;
import edu.shoppingMall.service.QnABoardService;

public class QnABoardServiceImpl implements QnABoardService {
    private static QnABoardServiceImpl service = new QnABoardServiceImpl();
    
    public static QnABoardServiceImpl getInstance() {
        return service;
    }
    
    /**
     * Q&A �Խ��� ��ü��ȸ
     * @return
     * @throws SQLException
     */
    @Override
    public List<QnABoardDTO> qnaBoardSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Q&A �Խ��� Ű���� �˻�
     * @param keyType
     * @param keyWord
     * @return
     * @throws SQLException
     */
    @Override
    public List<QnABoardDTO> qnaBoardSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Q&A �Խ��� �߰�
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int qnaBoardInsert(QnABoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Q&A �Խ��� ����
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int qnaBoardUpdate(QnABoardDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Q&A �Խ��� ����
     * @param qnaBoardNum
     * @return
     * @throws SQLException
     */
    @Override
    public int qnaBoardDelete(String qnaBoardNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
