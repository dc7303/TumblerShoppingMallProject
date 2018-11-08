package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.shoppingMall.dao.ProductInfoDAO;
import edu.shoppingMall.dto.ProductDTO;
import edu.shoppingMall.util.DBUtil;

public class ProductInfoDAOImpl implements ProductInfoDAO {
    private static ProductInfoDAOImpl daoImpl = new ProductInfoDAOImpl();
    
    
    public static ProductInfoDAOImpl getInstance() {
        return daoImpl;
    }
    /**
     * ��ǰ��ü�˻�
     */
    @Override
    public List<ProductDTO> productSelectAll() throws SQLException {
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<>();
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from tb_product");
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO(     
						rs.getInt("pno"),rs.getString("pname"),
						rs.getString("info"),rs.getInt("price"),
						rs.getString("category"),rs.getString("photo"),
						rs.getString("brand"),rs.getInt("stock"),
						rs.getString("regdt")			
						);
				
				list.add(dto);
			}
		}finally {
			DBUtil.dbClose(rs, ps, con);
		}
		
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
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into ??? values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            
            
            result = ps.executeUpdate();
        }finally {
            DBUtil.dbClose(ps, con);
        }
        return result;
    }
    
    /**
     * ��ǰ ����
     */
    @Override
    public int productUpdate(ProductDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update ??? set pro_info = ?, pro_price = ?, category = ?, picture = ?, brand = ? where pro_name = ?";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            
            
            result = ps.executeUpdate();
        }finally {
            DBUtil.dbClose(ps, con);
        }
        return result;
    }
    
    /**
     * ��ǰ ����
     */
    @Override
    public int productDelete(int productNum) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from ??? where pro_num = ?";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, productNum);
            
            result = ps.executeUpdate();
        }finally {
            DBUtil.dbClose(ps, con);
        }
        return result;
    }

}
