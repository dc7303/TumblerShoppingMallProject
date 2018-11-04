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
     * 상품전체검색
     */
    @Override
    public List<ProductDTO> productSelectAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from product";
        List<ProductDTO> list = new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                list.add(new ProductDTO(rs.getInt("pro_num"), rs.getString("pro_name"),
                        rs.getString("pro_info"), rs.getInt("pro_price"), rs.getString("category"),
                        rs.getString("picture"), rs.getString("brand")));
            }
            
        }finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return list;
    }

    /**
     * 상품 키워드 검색
     */
    @Override
    public List<ProductDTO> productSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * 상품 추가
     */
    @Override
    public int productInsert(ProductDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into product values (pro_num_seq.nextval, ?, ?, ?, ?, ?, ?)";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getProductName());
            ps.setString(2, dto.getProductInfo());
            ps.setInt(3, dto.getProductPrice());
            ps.setString(4, dto.getProductCategory());
            ps.setString(5, dto.getProductPicture());
            ps.setString(6, dto.getProductBrand());
            
            result = ps.executeUpdate();
        }finally {
            DBUtil.dbClose(ps, con);
        }
        return result;
    }
    
    /**
     * 상품 수정
     */
    @Override
    public int productUpdate(ProductDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update product set pro_info = ?, pro_price = ?, category = ?, picture = ?, brand = ? where pro_name = ?";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getProductInfo());
            ps.setInt(2, dto.getProductPrice());
            ps.setString(3, dto.getProductCategory());
            ps.setString(4, dto.getProductPicture());
            ps.setString(5, dto.getProductBrand());
            ps.setString(6, dto.getProductName());
            
            result = ps.executeUpdate();
        }finally {
            DBUtil.dbClose(ps, con);
        }
        return result;
    }
    
    /**
     * 상품 삭제
     */
    @Override
    public int productDelete(int productNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
