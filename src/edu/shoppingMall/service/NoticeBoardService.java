package edu.shoppingMall.service;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.NoticeBoardDTO;

/**
 * �������� �Խ��� Service Interface�Դϴ�.
 * ������ �������� ����ϴ� ���μ����Դϴ�.
 * @author mark
 *
 */
public interface NoticeBoardService {
    
    /**
     * �������� ��ü�˻�
     */
    List<NoticeBoardDTO> noticeBoardSelectAll() throws SQLException;

    /**
     * �������� �κа˻� ����
     */
 /*   List<NoticeBoardDTO> noticeBoardSelectBySearch(String keyType, String keyWord) throws SQLException;*/

    /**
     * �������� �߰�
     */
    int noticeBoardInsert(NoticeBoardDTO dto) throws SQLException;

    /**
     * �������� ����
     */
    int noticeBoardUpdate(NoticeBoardDTO dto) throws SQLException;

    /**
     * �������� ����
     */
    int noticeBoardDelete(int NoticeBoardNum) throws SQLException;
    
   /**
    * ���ڻ��׹�ȣ�� �˻� �߰�
    * 
    */
    NoticeBoardDTO selectByNoticeNum(int NoticeBoardNum)throws SQLException;
    
}
