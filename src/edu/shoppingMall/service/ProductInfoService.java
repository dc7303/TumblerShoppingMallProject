package edu.shoppingMall.service;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.ProductDTO;

/**
 * 제품 관리 Service Interface입니다.
 * 관리자 영역에서 사용하는 프로세서입니다.
 * @author mark
 *
 */
public interface ProductInfoService {
    
    /** 
     * 상품조회
     */  
    List<ProductDTO> productSelectAll() throws SQLException;
    
    /**
     * 상품부분검색
     */
    List<ProductDTO> productSelectBySearch(String keyType, String keyWord) throws SQLException;
    
    /**
     * 추가사항 - 상품상세페이지 : 상품번호에 해당하는 레코드 검색
     */
    ProductDTO productSelectByProductNum(int pno) throws SQLException; 
    
    /**
     * 상품추가
     */
    int productInsert(ProductDTO dto) throws SQLException;
    
    /**
     * 상품수정
     */
    int productUpdate(ProductDTO dto) throws SQLException;
    
    /**
     * 상품삭제
     */
    int productDelete(int productNum) throws SQLException;
}
