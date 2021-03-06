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
     * 상품 키워드 검색
     */
    @Override
    public List<ProductDTO> productSelectBySearch(String keyType, String keyWord) throws SQLException {
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<>();
		String sql = "select * from tb_product where ";
		
		try {
			if(keyType.equals("pno")) {
				sql+="pno like ?";
			}else if(keyType.equals("pname")) {
				sql+="pname like ?";
			}else if(keyType.equals("category")) {
				sql+="category like ?";
			}else {
				sql+="brand like ?";
			}
			
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO(
						rs.getInt("pno"),rs.getString("pname"),
						rs.getString("info"),rs.getInt("price"),
						rs.getString("category"),rs.getString("photo"),
						rs.getString("brand"),rs.getInt("stock"),
						rs.getString("regdt"));
				
				list.add(dto);
			}
		}finally {
			DBUtil.dbClose(rs, ps, con);
		}
		
		return list;
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
		int result = 0;
		String sql = "insert into tb_product(pno,pname,info,price,category,photo,brand,stock,regdt) values(?,?,?,?,?,?,?,?,sysdate)";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getProductNum());
			ps.setString(2, dto.getProductName());
			ps.setString(3, dto.getProductInfo());
			ps.setInt(4, dto.getProductPrice());
			ps.setString(5, dto.getProductCategory());
			ps.setString(6, dto.getProductPicture());
			ps.setString(7, dto.getProductBrand());
			ps.setInt(8, dto.getProductQuantity());
			
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
		int result = 0;
		String sql = "update tb_product set pname=?,info=?,price=?,category=?,photo=?,brand=?,stock=? where pno=?";//상품번호 변경불가
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getProductName());
			ps.setString(2, dto.getProductInfo());
			ps.setInt(3, dto.getProductPrice());
			ps.setString(4, dto.getProductCategory());
			ps.setString(5, dto.getProductPicture());
			ps.setString(6, dto.getProductBrand());
			ps.setInt(7, dto.getProductQuantity());
			ps.setInt(8, dto.getProductNum());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(ps, con);
		}
		
		return result;
	}
    
    /**
     * 상품 수량 수정
     * 주문 프로세서에서 상품 수량 감소
     */
    @Override
    public int productUpdateForQuantity(int productNum, int quantity) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update tb_product set stock = stock - ? where pno = ?";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, productNum);
            
            result = ps.executeUpdate();
        }finally {
            if(result > 0) {
                con.commit();
            }else {
                con.rollback();
            }
            DBUtil.dbClose(ps, con);
        }
        return result;
    }
    
    /**
     * 상품 삭제
     */
    @Override
    public int productDelete(int pno) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete tb_product where pno=?";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(ps, con);
		}
		return result;
	}

}