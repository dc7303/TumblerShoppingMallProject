package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.NoticeBoardDTO;

/**
 * QnA �Խ��� ���� DAO�̸�, �����ڿ� ���� �� �������� ����ϴ� ���μ����Դϴ�. QnABoardDTO ���� ��
 * qnaBoardChildNum�� ����ؼ� ��� ���� ������� �����մϴ�.
 * 
 * @author mark
 */
public interface NoticeDAO {

    /**
     * �Խñ� ��ü�˻�
     */
    List<NoticeBoardDTO> noticeBoardSelectAll() throws SQLException;

    /**
     * �Խñ� �κа˻�--> ����
     */
/*    List<NoticeBoardDTO> noticeBoardSelectBySearch(String keyType, String keyWord) throws SQLException;
*/
    /**
     * �Խñ� �߰�
     */
    int noticeBoardInsert(NoticeBoardDTO dto) throws SQLException;

    /**
     * �Խñ� ����
     */
    int noticeBoardUpdate(NoticeBoardDTO dto) throws SQLException;

    /**
     * �Խñ� ����
     */
    int noticeBoardDelete(int NoticeBoardNum) throws SQLException;

    /**
     * ������ȣ�� �κа˻� �߰� 
     * 
     */
    NoticeBoardDTO selectByNoticeNum(int NoticeBoardNum) throws SQLException;
}
