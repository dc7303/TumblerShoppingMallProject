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
        
        return list;
    }
    
    /**
     * ��ǰ Ű���� �˻�
     */
    @Override
    public List<ProductDTO> productSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * ��ǰ �߰�
     */
    @Override
    public int productInsert(ProductDTO dto) throws SQLException {
        int result = daoImpl.productInsert(dto);
        return result;
    }
    
    /**
     * ��ǰ ����
     */
    @Override
    public int productUpdate(ProductDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    /**
     * ��ǰ ����
     */
    @Override
    public int productDelete(int productNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
