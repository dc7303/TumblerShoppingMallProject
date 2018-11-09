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
     * ��ǰ Ű���� �˻�
     */
    @Override
    public List<ProductDTO> productSelectBySearch(String keyType, String keyWord) throws SQLException {
        
        return null;
    }
    
    /**
     * ��ǰ ��ȣ�� �˻�(Order ���μ��� �۵��� ��ǰ����(����)�� �������� ���� ��)
     * ���� ���� ���ɼ��� �־� select * from ���� ��ü ���� �ҷ��� �� �ֵ��� �ڵ� ����.
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
