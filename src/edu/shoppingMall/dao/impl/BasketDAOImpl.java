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
     *  장바구니 전체조회
     */
    @Override
    public List<BasketDTO> basketSelectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 장바구니 키워드 조회(장바구니 번호조회)
     */
    @Override
    public BasketDTO basketSelectByBasketNum(int basketNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 장바구니 키워드 조회(유저 ID 조회)
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
     * 장바구니 추가
     */
    @Override
    public int basketInsert(BasketDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 장바구니 수정
     */
    @Override
    public int basketUpdate(BasketDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 장바구니 삭제
     */
    @Override
    public int basketDelete(String userId) throws SQLException {
      Connection con=null;
      PreparedStatement ps =null;
      int result=0;
      
      try {
         //로드 연결 실행 닫기
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
