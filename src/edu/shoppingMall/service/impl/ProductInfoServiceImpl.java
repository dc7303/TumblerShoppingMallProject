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
     * 제품 전체검색
     */
    @Override
    public List<ProductDTO> productSelectAll() throws SQLException {
    	List<ProductDTO> list = daoImpl.productSelectAll();
		if(list==null || list.size()==0) {
			throw new SQLException("검색된 상품이 없습니다.");
		}
		return list;
    }
    
    /**
     * 제품 키워드 검색
     */
    @Override
    public List<ProductDTO> productSelectBySearch(String keyType, String keyWord) throws SQLException {
    	List<ProductDTO> list = daoImpl.productSelectBySearch(keyType, keyWord);
    	if(list == null) {
            throw new SQLException(keyType+"에 "+keyWord+"가 포함된 상품이 없습니다.");
        }
        return list;
    }
    
    /**
     * 추가사항 - 제품번호로 하나의 제품찾기 
     */
    @Override
    public ProductDTO productSelectByProductNum(int productNum) throws SQLException {
    	List<ProductDTO> list = daoImpl.productSelectAll();
    	ProductDTO dto = daoImpl.productSelectByProductNum(productNum);
    	
    	if(list == null || list.size()==0) {
			if(dto != list.get(productNum)) {
				throw new SQLException(productNum+"인 상품번호인 상품이 없습니다.");
			}
		}
		return dto;
    }
    
    /**
     * 제품 추가
     */
    @Override
    public int productInsert(ProductDTO dto) throws SQLException {
        int result = daoImpl.productInsert(dto);
        if(result == 0) {
            throw new SQLException("제품 추가에 실패했습니다.");
        }
        return result;
    }
    
    /**
     * 제품 수정
     */
    @Override
    public int productUpdate(ProductDTO dto) throws SQLException {
        int result = daoImpl.productUpdate(dto);
        if(result == 0) {
            throw new SQLException("제품 수정에 실패했습니다.");
        }
        return result;
    }
    
    /**
     * 제품 삭제
     */
    @Override
    public int productDelete(int productNum) throws SQLException {
        int result = daoImpl.productDelete(productNum);
        if(result == 0) {
            throw new SQLException("제품 삭제에 실패했습니다.");
        }
        return result;
    }

}
