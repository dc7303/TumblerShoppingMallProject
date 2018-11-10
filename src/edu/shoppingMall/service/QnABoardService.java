package edu.shoppingMall.service;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.QnABoardDTO;

/**
 * QnA�Խ��� Service Interface�Դϴ�.
 * ������ ������ �� �������� ����ϴ� ���μ����Դϴ�.
 * @author mark
 *
 */
public interface QnABoardService {
    
    /**
     * �Խñ� ��ü�˻�
     */
    List<QnABoardDTO> qnaBoardSelectAll() throws SQLException;
    
    /**
     * �Խñ� �κа˻�
     */
    List<QnABoardDTO> qnaBoardSelectBySearch(String keyType, String keyWord) throws SQLException;
    
    /**
     * �Խñ� �߰�
     */
    int qnaBoardInsert(QnABoardDTO dto) throws SQLException;
    
    /**
     * �Խñ� ����
     */
    int qnaBoardUpdate(QnABoardDTO dto) throws SQLException;
    
    /**
     * �Խñ� ����
     */
    int qnaBoardDelete(int qno) throws SQLException;
    
    /**
     * �Խñ� ��ȸ
     */
    QnABoardDTO qnaBoardSelectByNo(int no) throws SQLException;
}
