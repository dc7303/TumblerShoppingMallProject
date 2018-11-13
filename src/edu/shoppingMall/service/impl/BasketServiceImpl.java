package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.BasketDAO;
import edu.shoppingMall.dao.ProductInfoDAO;
import edu.shoppingMall.dao.impl.BasketDAOImpl;
import edu.shoppingMall.dao.impl.ProductInfoDAOImpl;
import edu.shoppingMall.dto.BasketDTO;
import edu.shoppingMall.service.BasketService;

public class BasketServiceImpl implements BasketService {
    private static BasketServiceImpl service = new BasketServiceImpl();
    private BasketDAO basketDAO = BasketDAOImpl.getInstance();
    public static BasketServiceImpl getInstance () {
        return service;
    }
    
    /**
     * 장바구니 전체조회
     */
    @Override
    public List<BasketDTO> basketSelectAll() throws SQLException {
       List<BasketDTO>list = basketDAO.basketSelectAll();
      if(list==null)throw new SQLException("장바구니 조회결과가 없습니다."); 
       return list;
    }

    /**
     * 장바구니 키워드 조회 (장바구니 번호)
     */
    @Override
    public BasketDTO basketSelectByBasketNum(int basketNum) throws SQLException {
       BasketDTO basketdto = basketDAO.basketSelectByBasketNum(basketNum);
       if(basketdto==null)throw new SQLException("장바구니 조회결과가 없습니다.");
       return basketdto;
    }

    /**
     * 장바구니 키워드 조회 (유저 ID로 조회)
     */
    @Override
    public List<BasketDTO> basketSelectByUserId(String userId) throws SQLException {
    	List<BasketDTO> list = basketDAO.basketSelectByUserId(userId);
    	if(list==null)throw new SQLException("검색한 id로 조회한 결과가 없습니다.");
    	return list; 
    }

    /**
     * 장바구니 추가
     */
    @Override
    public int basketInsert(BasketDTO dto) throws SQLException {
    	int result = basketDAO.basketInsert(dto);
    	if(result==0)throw new SQLException("등록되지 않았습니다.");
    	return result;
    	
    }
    
    /**
     * 장바구니 수정
     */
    @Override
    public int basketUpdate(BasketDTO dto) throws SQLException {
       int result = basketDAO.basketUpdate(dto);
       if(result==0)throw new SQLException("수정되지 않았습니다.");
       return result;
    }

    /**
     * 장바구니 삭제
     */
    @Override
    public int baksetDelete(String userId) throws SQLException {
    	int result = basketDAO.basketDelete(userId);
    	if(result==0)throw new SQLException("검색된 물품이 없습니다.");
    	return result;
    }
    
    /**
     * 장바구니 단일삭제
     * @param basketNum
     * @return
     * @throws SQLException
     */
    public int basketDeleteByBasketNum(int basketNum) throws SQLException{
        int result = basketDAO.basketDeleteByBasketNum(basketNum);
        if(result==0)throw new SQLException("삭제 실패했습니다.");
        return result;
    }

}
