package edu.shoppingMall.service.adminService;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.ProductDTO;

/**
 * ��ǰ ���� Service Interface�Դϴ�.
 * ������ �������� ����ϴ� ���μ����Դϴ�.
 * @author mark
 *
 */
public interface ProductInfoService {
    
    /** 
     * ��ǰ��ȸ
     */  
    List<ProductDTO> productSelectAll() throws SQLException;
    
    /**
     * ��ǰ�κа˻�
     */
    List<ProductDTO> productSelectBySearch(String keyType, String keyWord) throws SQLException;
    
    /**
     * ��ǰ�߰�
     */
    int productInsert(ProductDTO dto) throws SQLException;
    
    /**
     * ��ǰ����
     */
    int productUpdate(ProductDTO dto) throws SQLException;
    
    /**
     * ��ǰ����
     */
    int productDelete(int productNum) throws SQLException;
}
