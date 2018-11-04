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
        // TODO Auto-generated method stub
        return 0;
    }
    
    /**
     * ��ǰ ����
     */
    @Override
    public int productUpdate(ProductDTO dto) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    /**
     * ��ǰ ����
     */
    @Override
    public int productDelete(int productNum) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}