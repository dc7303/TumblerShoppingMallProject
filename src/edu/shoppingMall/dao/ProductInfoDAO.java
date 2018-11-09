package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.ProductDTO;


/**
 * ��ǰ������ ���õ� DAO
 * ������ ������ ���������� �����ڱ��ѿ� ���ߵǾ��ֽ��ϴ�.
 * @author mark
 *
 */
public interface ProductInfoDAO {

    /** 
     * ��ǰ��ȸ
     */  
    List<ProductDTO> productSelectAll() throws SQLException;
    
    /**
     * ��ǰ�κа˻�
     */
    List<ProductDTO> productSelectBySearch(String keyType, String keyWord) throws SQLException;
    
    /**
     * ��ǰ ��ȣ�� �˻�(Order ���μ��� �۵��� ��ǰ����(����)�� �������� ���� ��)
     */
    ProductDTO productSelectByProductNum(int pno) throws SQLException;
    
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
