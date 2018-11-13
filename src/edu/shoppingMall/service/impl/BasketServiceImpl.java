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
     * ��ٱ��� ��ü��ȸ
     */
    @Override
    public List<BasketDTO> basketSelectAll() throws SQLException {
       List<BasketDTO>list = basketDAO.basketSelectAll();
      if(list==null)throw new SQLException("��ٱ��� ��ȸ����� �����ϴ�."); 
       return list;
    }

    /**
     * ��ٱ��� Ű���� ��ȸ (��ٱ��� ��ȣ)
     */
    @Override
    public BasketDTO basketSelectByBasketNum(int basketNum) throws SQLException {
       BasketDTO basketdto = basketDAO.basketSelectByBasketNum(basketNum);
       if(basketdto==null)throw new SQLException("��ٱ��� ��ȸ����� �����ϴ�.");
       return basketdto;
    }

    /**
     * ��ٱ��� Ű���� ��ȸ (���� ID�� ��ȸ)
     */
    @Override
    public List<BasketDTO> basketSelectByUserId(String userId) throws SQLException {
    	List<BasketDTO> list = basketDAO.basketSelectByUserId(userId);
    	if(list==null)throw new SQLException("�˻��� id�� ��ȸ�� ����� �����ϴ�.");
    	return list; 
    }

    /**
     * ��ٱ��� �߰�
     */
    @Override
    public int basketInsert(BasketDTO dto) throws SQLException {
    	int result = basketDAO.basketInsert(dto);
    	if(result==0)throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
    	return result;
    	
    }
    
    /**
     * ��ٱ��� ����
     */
    @Override
    public int basketUpdate(BasketDTO dto) throws SQLException {
       int result = basketDAO.basketUpdate(dto);
       if(result==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
       return result;
    }

    /**
     * ��ٱ��� ����
     */
    @Override
    public int baksetDelete(String userId) throws SQLException {
    	int result = basketDAO.basketDelete(userId);
    	if(result==0)throw new SQLException("�˻��� ��ǰ�� �����ϴ�.");
    	return result;
    }
    
    /**
     * ��ٱ��� ���ϻ���
     * @param basketNum
     * @return
     * @throws SQLException
     */
    public int basketDeleteByBasketNum(int basketNum) throws SQLException{
        int result = basketDAO.basketDeleteByBasketNum(basketNum);
        if(result==0)throw new SQLException("���� �����߽��ϴ�.");
        return result;
    }

}
