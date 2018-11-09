package edu.shoppingMall.dao;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dto.ProductDTO;


/**
 * 상품관리에 관련된 DAO
 * 관리자 페이지 영역임으로 관리자권한에 집중되어있습니다.
 * @author mark
 *
 */
public interface ProductInfoDAO {

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
