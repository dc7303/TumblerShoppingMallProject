package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.shoppingMall.dao.OrderDAO;
import edu.shoppingMall.dto.BasongDTO;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.dto.OrderDetailDTO;
import edu.shoppingMall.util.DBUtil;

public class OrderDAOImpl implements OrderDAO {
    private static OrderDAOImpl daoImpl = new OrderDAOImpl();
    
    public static OrderDAOImpl getInstance() {
        return daoImpl;
    }
    
    /**
     * select o.ono, userid, paydt, payment, other, de.dno, pno, price, amount,
d_option, orderdt, ve.dno, company, shipnum, addr, phone, startdate, status 
from tb_order o join tb_detail de on o.ono = de.ono 
join tb_delivery ve on o.ono = ve.ono;
     */
    /**
     * 주문 전체 조회
     * 관리자 판매내역 확인
     * @return
     * @throws SQLException
     */
    @Override
    public List<OrderDTO> orderSelectAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //주문번호가 같은 TB_Detail, TB_Delivery 테이블 Join해서 가져오기
        /*
         * (순서 나열은 아래 쿼리문 개행과 동일하니 순서대로 보시면됩니다.)
         * 
         * 순서 : 주문번호, 유저아이디, 결제일, 가격, 기타사항, 디테일번호, 상품번호, 가격, 주문수량,
         * 주문옵션, 주문일자, 배송번호, 배송회사, 송장번호, 배송주소, 휴대폰번호, 배송시작일, 배송상태
         */
        
        String sql = "select o.ono, userid, paydt, payment, other, de.dno, pno, price, amount," + 
                "d_option, orderdt, ve.dno ve_dno, company, shipnum, addr, phone, startdate, status " + 
                "from tb_order o join tb_detail de on o.ono = de.ono " + 
                "join tb_delivery ve on o.ono = ve.ono";
        List<OrderDTO> list = new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                //주문 상세 DTO 생성 (중간에 "ono"는 주문번호)
                OrderDetailDTO detailDTO = new OrderDetailDTO(rs.getInt("dno"), rs.getInt("ono"), rs.getInt("pno"),
                        rs.getInt("price"), rs.getInt("amount"), rs.getString("d_option"), rs.getString("orderdt"));
                
                //배송 DTO 생성 (중간에 "ono"는 주문번호)
                BasongDTO basongDTO = new BasongDTO(rs.getInt("ve_dno"), rs.getString("company"), rs.getString("shipnum"),
                        rs.getString("addr"), rs.getString("phone"), rs.getString("startdate"), rs.getInt("ono"), rs.getInt("status"));
                
                //OrderDTO에 불러온 값 모두 넣고 리스트에 ADD
                list.add(new OrderDTO(rs.getInt("ono"), rs.getString("userid"), rs.getString("paydt"),
                        rs.getInt("payment"), rs.getString("other"), detailDTO, basongDTO));
            }
        }finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return list;
    }

    /**
     * 주문 키워드 검색 (ID로 검색)
     * 마이페이지 주문내역 확인
     */
    @Override
    public List<OrderDTO> orderSelectByUserId(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        /*
         * (순서 나열은 아래 쿼리문 개행과 동일하니 순서대로 보시면됩니다.)
         * 
         * 순서 : 주문번호, 유저아이디, 결제일, 가격, 기타사항, 디테일번호, 상품번호, 가격, 주문수량,
         * 주문옵션, 주문일자, 배송번호, 배송회사, 송장번호, 배송주소, 휴대폰번호, 배송시작일, 배송상태
         */
        
        String sql = "select o.ono, userid, paydt, payment, other, de.dno, pno, price, amount," + 
                "d_option, orderdt, ve.dno ve_dno, company, shipnum, addr, phone, startdate, status " + 
                "from tb_order o join tb_detail de on o.ono = de.ono " + 
                "join tb_delivery ve on o.ono = ve.ono where o.userid = ?";
        List<OrderDTO> list = new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while(rs.next()) {
                //주문 상세 DTO 생성 (중간에 "ono"는 주문번호)
                OrderDetailDTO detailDTO = new OrderDetailDTO(rs.getInt("dno"), rs.getInt("ono"), rs.getInt("pno"),
                        rs.getInt("price"), rs.getInt("amount"), rs.getString("d_option"), rs.getString("orderdt"));
                
                //배송 DTO 생성 (중간에 "ono"는 주문번호)
                BasongDTO basongDTO = new BasongDTO(rs.getInt("ve_dno"), rs.getString("company"), rs.getString("shipnum"),
                        rs.getString("addr"), rs.getString("phone"), rs.getString("startdate"), rs.getInt("ono"), rs.getInt("status"));
                
                //OrderDTO에 불러온 값 모두 넣고 리스트에 ADD
                list.add(new OrderDTO(rs.getInt("ono"), rs.getString("userid"), rs.getString("paydt"),
                        rs.getInt("payment"), rs.getString("other"), detailDTO, basongDTO));
            }
        }finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return list;
    }

    /**
     * 주문 키워드 검색 (주문번호로 검색)
     * 주문 상세보기
     */
    @Override
    public OrderDTO orderSelectByOrderNum(int orderNum) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        /*
         * (순서 나열은 아래 쿼리문 개행과 동일하니 순서대로 보시면됩니다.)
         * 
         * 순서 : 주문번호, 유저아이디, 결제일, 가격, 기타사항, 디테일번호, 상품번호, 가격, 주문수량,
         * 주문옵션, 주문일자, 배송번호, 배송회사, 송장번호, 배송주소, 휴대폰번호, 배송시작일, 배송상태
         */
        
        String sql = "select o.ono, userid, paydt, payment, other, de.dno, pno, price, amount," + 
                "d_option, orderdt, ve.dno ve_dno, company, shipnum, addr, phone, startdate, status " + 
                "from tb_order o join tb_detail de on o.ono = de.ono " + 
                "join tb_delivery ve on o.ono = ve.ono where o.ono = ?";
        OrderDTO orderDTO = null;
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, orderNum);
            rs = ps.executeQuery();
            while(rs.next()) {
                //주문 상세 DTO 생성 (중간에 "ono"는 주문번호)
                OrderDetailDTO detailDTO = new OrderDetailDTO(rs.getInt("dno"), rs.getInt("ono"), rs.getInt("pno"),
                        rs.getInt("price"), rs.getInt("amount"), rs.getString("d_option"), rs.getString("orderdt"));
                
                //배송 DTO 생성 (중간에 "ono"는 주문번호)
                BasongDTO basongDTO = new BasongDTO(rs.getInt("ve_dno"), rs.getString("company"), rs.getString("shipnum"),
                        rs.getString("addr"), rs.getString("phone"), rs.getString("startdate"), rs.getInt("ono"), rs.getInt("status"));
                
                //OrderDTO에 불러온 값 모두 넣고 리스트에 ADD
                orderDTO = new OrderDTO(rs.getInt("ono"), rs.getString("userid"), rs.getString("paydt"),
                        rs.getInt("payment"), rs.getString("other"), detailDTO, basongDTO);
            }
        }finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return orderDTO;
    }
    
    
    /**
     * 주문 생성
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int orderInsert(OrderDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into tb_order values (order_seq.nextval, ?, sysdate, ?, ?)";
        int result = 0;

        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getOrderUserId());
            ps.setInt(2, dto.getOrderPrice());
            ps.setString(3, dto.getOrderComment());
            
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
     * 현재 시퀀스값 가져오기
     * @return
     * @throws SQLException
     */
    public int orderSeqSearch() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select order_seq.currval from dual";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                result = rs.getInt("currval");
            }
        }finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return result;
    }

    /**
     * 주문내역 수정
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int orderUpdate(OrderDTO dto) throws SQLException {

        return 0;
    }

    /**
     * 주문 취소(삭제)
     * @param orderNum
     * @return
     * @throws SQLException
     */
    @Override
    public int orderDelete(int orderNum) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from tb_order where ono = ? ";
        int result = 0;
        
        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(sql);
            ps.setInt(1, orderNum);
            
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

}
