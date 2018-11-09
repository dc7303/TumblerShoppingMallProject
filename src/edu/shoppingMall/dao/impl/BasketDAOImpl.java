package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.shoppingMall.dao.BasketDAO;
import edu.shoppingMall.dto.BasketDTO;
import edu.shoppingMall.util.DBUtil;

public class BasketDAOImpl implements BasketDAO {
    private static BasketDAOImpl basketDAO = new BasketDAOImpl();
    
    public static BasketDAOImpl getInstance() {
        return basketDAO;
    }
    
    /**
     *  ��ٱ��� ��ü��ȸ
     */
    @Override
    public List<BasketDTO> basketSelectAll() throws SQLException {
      Connection con = null;
      PreparedStatement ps= null;
      ResultSet rs = null;
      List<BasketDTO> list = new ArrayList<>();
      
      try {
    	  con = DBUtil.getConnection();
    	  ps = con.prepareStatement("select * from tb_basket");
    	  rs= ps.executeQuery();
    	  while(rs.next()) {
    		  list.add(new BasketDTO(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),
    				  rs.getInt(5), rs.getInt(6)));}
    		  System.out.println(list);
    	  
    		  
      	} catch (SQLException e) {
      	e.printStackTrace();
      	}finally {
		DBUtil.dbClose(rs,ps,con );
		
      	}
      	return list;
    	}

    /**
     * ��ٱ��� Ű���� ��ȸ(��ٱ��� ��ȣ��ȸ)
     */
    @Override
    public BasketDTO basketSelectByBasketNum(int basketNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��ٱ��� Ű���� ��ȸ(���� ID ��ȸ)
     */
    @Override
    public List<BasketDTO> basketSelectByUserId(String userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��ٱ��� �߰�
     */
    @Override
    public int basketInsert(BasketDTO dto) throws SQLException {
  /*     Connection con = null;
       PreparedStatement ps = null;
       int result=0;
       
       try {
    	   con= DBUtil.getConnection();
    	   ps=con.prepareStatement(insert into tb_basket valuse())
    			 
    	   
    	   
       }
       */
    	 return 0;
       
    }

    /**
     * ��ٱ��� ����
     */
    @Override
    public int basketUpdate(BasketDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * ��ٱ��� ����
     */
    @Override
    public int baksetDelete(int basketNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
