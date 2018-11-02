package edu.shoppingMall.service.adminService;

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
     * �Խù���ȸ
     */
    List<NoticeBoardDTO> noticeBoardSelectAll() throws SQLException;
    
    /**
     * �Խù�Ű���� ��ȸ
     */
    List<NoticeBoardDTO> noticeBoardSelectBySearch(String keyType, String keyWord) throws SQLException;
    
    /**
     * �Խù��߰�
     */
    int noticeBoardInsert(NoticeBoardDTO dto) throws SQLException;
    
    /**
     * �Խù�����
     */
    int noticeBoardUpdate(NoticeBoardDTO dto) throws SQLException;
    
    /**
     * �Խù�����
     */
    int noticeBoardDelete(int noticeBoardNum) throws SQLException;
}
