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
        String sql = "select * from ???";
        List<ProductDTO> list = new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                list.add(new ProductDTO());
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
        
        return null;
    }
    
    /**
     * 상품 번호로 검색(Order 프로세서 작동시 상품정보(가격)를 가져오기 위한 것)
     * 추후 재사용 가능성이 있어 select * from 으로 전체 정보 불러올 수 있도록 코드 구현.
     */
    @Override
    public ProductDTO productSelectByProductNum(int pno) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from tb_product where pno = ?";
        ProductDTO proDTO = new ProductDTO();
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pno);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                proDTO = new ProductDTO(rs.getInt("pno"), rs.getString("pname"), rs.getString("info"),
                        rs.getInt("price"), rs.getString("category"), rs.getString("photo"),
                        rs.getString("brand"), rs.getInt("stock"), rs.getString("regdt"));
            }
            
        }finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return proDTO;
    }
    
    /**
     * 상품 추가
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
     * 상품 수정
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
     * 상품 삭제
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
