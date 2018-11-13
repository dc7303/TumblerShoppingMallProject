package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.ProductInfoDAO;
import edu.shoppingMall.dao.impl.ProductInfoDAOImpl;
import edu.shoppingMall.dto.ProductDTO;
import edu.shoppingMall.service.ProductInfoService;

public class ProductInfoServiceImpl implements ProductInfoService {
    private static ProductInfoServiceImpl service = new ProductInfoServiceImpl();
    private ProductInfoDAO daoImpl = ProductInfoDAOImpl.getInstance();
    
    public static ProductInfoServiceImpl getInstance() {
        return service;
    }
    
    /**
     * ��ǰ ��ü�˻�
     */
    @Override
    public List<ProductDTO> productSelectAll() throws SQLException {
    	List<ProductDTO> list = daoImpl.productSelectAll();
		if(list==null || list.size()==0) {
			throw new SQLException("�˻��� ��ǰ�� �����ϴ�.");
		}
		return list;
    }
    
    /**
     * ��ǰ Ű���� �˻�
     */
    @Override
    public List<ProductDTO> productSelectBySearch(String keyType, String keyWord) throws SQLException {
    	List<ProductDTO> list = daoImpl.productSelectBySearch(keyType, keyWord);
    	if(list == null) {
            throw new SQLException(keyType+"�� "+keyWord+"�� ���Ե� ��ǰ�� �����ϴ�.");
        }
        return list;
    }
    
    /**
     * �߰����� - ��ǰ��ȣ�� �ϳ��� ��ǰã�� 
     */
    @Override
    public ProductDTO productSelectByProductNum(int productNum) throws SQLException {
    	List<ProductDTO> list = daoImpl.productSelectAll();
    	ProductDTO dto = daoImpl.productSelectByProductNum(productNum);
    	
    	if(list == null || list.size()==0) {
			if(dto != list.get(productNum)) {
				throw new SQLException(productNum+"�� ��ǰ��ȣ�� ��ǰ�� �����ϴ�.");
			}
		}
		return dto;
    }
    
    /**
     * ��ǰ �߰�
     */
    @Override
    public int productInsert(ProductDTO dto) throws SQLException {
        int result = daoImpl.productInsert(dto);
        if(result == 0) {
            throw new SQLException("��ǰ �߰��� �����߽��ϴ�.");
        }
        return result;
    }
    
    /**
     * ��ǰ ����
     */
    @Override
    public int productUpdate(ProductDTO dto) throws SQLException {
        int result = daoImpl.productUpdate(dto);
        if(result == 0) {
            throw new SQLException("��ǰ ������ �����߽��ϴ�.");
        }
        return result;
    }
    
    /**
     * ��ǰ ����
     */
    @Override
    public int productDelete(int productNum) throws SQLException {
        int result = daoImpl.productDelete(productNum);
        if(result == 0) {
            throw new SQLException("��ǰ ������ �����߽��ϴ�.");
        }
        return result;
    }

}
