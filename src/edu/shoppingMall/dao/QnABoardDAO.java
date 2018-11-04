package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.QnABoardDTO;


/**
 * QnA �Խ��� ���� DAO�̸�, �����ڿ� ���� �� �������� ����ϴ� ���μ����Դϴ�.
 * QnABoardDTO ���� �� qnaBoardChildNum�� ����ؼ� ��� ���� ������� �����մϴ�.
 * @author mark
 *
 */
public interface QnABoardDAO {
    
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
    int qnaBoardDelete(String qnaBoardNum) throws SQLException;
    
    
}
