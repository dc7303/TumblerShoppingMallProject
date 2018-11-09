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
        // TODO Auto-generated method stub
        return null;
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
      Connection con = DBUtil.getConnection();
      PreparedStatement ps =null;
      ResultSet rs =null;
      BasketDTO dto = null;
      List<BasketDTO> list = new ArrayList<>();
      try{
          ps = con.prepareStatement("select * from tb_basket where userid = ?");
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
        // TODO Auto-generated method stub
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
    public int basketDelete(String userId) throws SQLException {
      Connection con=null;
      PreparedStatement ps =null;
      int result=0;
      
      try {
         //�ε� ���� ���� �ݱ�
         con=DBUtil.getConnection();
         con.setAutoCommit(false);
         ps = con.prepareStatement("delete from tb_basket where userid = ?");
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
