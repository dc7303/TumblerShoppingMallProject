package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.shoppingMall.dao.BasketDAO;
import edu.shoppingMall.dto.BasketDTO;
import edu.shoppingMall.dto.NoticeBoardDTO;
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
    		  //System.out.println(list);
    	  
    		  
     
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
    	Connection con = DBUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs =null;
		BasketDTO dto = null;
		try{
			 ps = con.prepareStatement( "select * from tb_basket where bno=?");
			 ps.setInt(1, basketNum);
			 rs = ps.executeQuery();
			 if(rs.next()){
				 dto = new BasketDTO(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),
	    				  rs.getInt(5), rs.getInt(6));
				 }
			}finally{
				DBUtil.dbClose(rs, ps, con);
				}
			return dto;
			}
    

    /**
     * ��ٱ��� Ű���� ��ȸ(���� ID ��ȸ)
     */
    @Override
    public List<BasketDTO> basketSelectByUserId(String userId) throws SQLException {
    	Connection con = DBUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs =null;
		BasketDTO dto = null;
		List<BasketDTO> list = new ArrayList<>();
		try{
			 ps = con.prepareStatement( "select * from tb_basket where userid=?");
			 ps.setString(1, userId);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 
				 list.add(new BasketDTO(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),
	    				  rs.getInt(5), rs.getInt(6)));
				 }
			}finally{
				DBUtil.dbClose(rs, ps, con);
				}
			return list ;
			}
    

    /**
     * ��ٱ��� �߰�
     */
    @Override
    public int basketInsert(BasketDTO dto) throws SQLException {
       Connection con = null;
       PreparedStatement ps = null;
       int result=0;

       
       try {
    	   con= DBUtil.getConnection();
    	   ps=con.prepareStatement("insert into tb_basket values(basket_seq.nextval,?,?,?,?,?)");
    	   ps.setInt(1, dto.getProductNum());
    	   ps.setString(2, dto.getUserId());
    	   ps.setString(3, dto.getBasketOption());
    	   ps.setInt(4, dto.getBasketQuantity());
    	   ps.setInt(5, dto.getBasketPrice());

    	   
    	   result = ps.executeUpdate();
       
       
       }finally {
    	   DBUtil.dbClose(ps, con);
       }
  
       return result;
    }

    /**
     * ��ٱ��� ����
     */
    @Override
    public int basketUpdate(BasketDTO dto) throws SQLException {
    	Connection con =DBUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try {
			ps = con.prepareStatement("update tb_basket set+"
				+ " bno=?,pno=?,userid=? b_option=?, amonut=? ,price=?");
			ps.setInt(1, dto.getBasketNum());
			ps.setInt(2,dto.getProductNum());
			ps.setString(3, dto.getUserId());
			ps.setString(4, dto.getBasketOption());
			ps.setInt(5, dto.getBasketQuantity());
			ps.setInt(6, dto.getBasketPrice());
			
			result = ps.executeUpdate();
			
			}finally {
				DBUtil.dbClose(ps, con);
			}
				
				return result;
    		
    		}

    //catch ����
    //��ٱ��� ���� �Ű����� �� ���� ���
    //dao �� ����, ��Ʈ�ѷ� ����
    /**
     * ��ٱ��� ����
     */
    @Override
    public int baksetDelete(String userId) throws SQLException {
    	Connection con=null;
		PreparedStatement ps =null;
		int result=0;
		;
		try {
			//�ε� ���� ���� �ݱ�
			con=DBUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement("delete from tb_basket where userid=?");
			ps.setString(1, userId);
			result = ps.executeUpdate();
		}finally {
			if(result > 0) {
				con.commit();
			}else {
				con.rollback();
			}
			DBUtil.dbClose( ps, con);
		}
		return result;
	
    }

}
