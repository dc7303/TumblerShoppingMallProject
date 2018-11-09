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
     * �ֹ� ��ü ��ȸ
     * ������ �Ǹų��� Ȯ��
     * @return
     * @throws SQLException
     */
    @Override
    public List<OrderDTO> orderSelectAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //�ֹ���ȣ�� ���� TB_Detail, TB_Delivery ���̺� Join�ؼ� ��������
        /*
         * (���� ������ �Ʒ� ������ ����� �����ϴ� ������� ���ø�˴ϴ�.)
         * 
         * ���� : �ֹ���ȣ, �������̵�, ������, ����, ��Ÿ����, �����Ϲ�ȣ, ��ǰ��ȣ, ����, �ֹ�����,
         * �ֹ��ɼ�, �ֹ�����, ��۹�ȣ, ���ȸ��, �����ȣ, ����ּ�, �޴�����ȣ, ��۽�����, ��ۻ���
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
                //�ֹ� �� DTO ���� (�߰��� "ono"�� �ֹ���ȣ)
                OrderDetailDTO detailDTO = new OrderDetailDTO(rs.getInt("dno"), rs.getInt("ono"), rs.getInt("pno"),
                        rs.getInt("price"), rs.getInt("amount"), rs.getString("d_option"), rs.getString("orderdt"));
                
                //��� DTO ���� (�߰��� "ono"�� �ֹ���ȣ)
                BasongDTO basongDTO = new BasongDTO(rs.getInt("ve_dno"), rs.getString("company"), rs.getString("shipnum"),
                        rs.getString("addr"), rs.getString("phone"), rs.getString("startdate"), rs.getInt("ono"), rs.getInt("status"));
                
                //OrderDTO�� �ҷ��� �� ��� �ְ� ����Ʈ�� ADD
                list.add(new OrderDTO(rs.getInt("ono"), rs.getString("userid"), rs.getString("paydt"),
                        rs.getInt("payment"), rs.getString("other"), detailDTO, basongDTO));
            }
        }finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return list;
    }

    /**
     * �ֹ� Ű���� �˻� (ID�� �˻�)
     * ���������� �ֹ����� Ȯ��
     */
    @Override
    public List<OrderDTO> orderSelectByUserId(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        /*
         * (���� ������ �Ʒ� ������ ����� �����ϴ� ������� ���ø�˴ϴ�.)
         * 
         * ���� : �ֹ���ȣ, �������̵�, ������, ����, ��Ÿ����, �����Ϲ�ȣ, ��ǰ��ȣ, ����, �ֹ�����,
         * �ֹ��ɼ�, �ֹ�����, ��۹�ȣ, ���ȸ��, �����ȣ, ����ּ�, �޴�����ȣ, ��۽�����, ��ۻ���
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
                //�ֹ� �� DTO ���� (�߰��� "ono"�� �ֹ���ȣ)
                OrderDetailDTO detailDTO = new OrderDetailDTO(rs.getInt("dno"), rs.getInt("ono"), rs.getInt("pno"),
                        rs.getInt("price"), rs.getInt("amount"), rs.getString("d_option"), rs.getString("orderdt"));
                
                //��� DTO ���� (�߰��� "ono"�� �ֹ���ȣ)
                BasongDTO basongDTO = new BasongDTO(rs.getInt("ve_dno"), rs.getString("company"), rs.getString("shipnum"),
                        rs.getString("addr"), rs.getString("phone"), rs.getString("startdate"), rs.getInt("ono"), rs.getInt("status"));
                
                //OrderDTO�� �ҷ��� �� ��� �ְ� ����Ʈ�� ADD
                list.add(new OrderDTO(rs.getInt("ono"), rs.getString("userid"), rs.getString("paydt"),
                        rs.getInt("payment"), rs.getString("other"), detailDTO, basongDTO));
            }
        }finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return list;
    }

    /**
     * �ֹ� Ű���� �˻� (�ֹ���ȣ�� �˻�)
     * �ֹ� �󼼺���
     */
    @Override
    public OrderDTO orderSelectByOrderNum(int orderNum) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        /*
         * (���� ������ �Ʒ� ������ ����� �����ϴ� ������� ���ø�˴ϴ�.)
         * 
         * ���� : �ֹ���ȣ, �������̵�, ������, ����, ��Ÿ����, �����Ϲ�ȣ, ��ǰ��ȣ, ����, �ֹ�����,
         * �ֹ��ɼ�, �ֹ�����, ��۹�ȣ, ���ȸ��, �����ȣ, ����ּ�, �޴�����ȣ, ��۽�����, ��ۻ���
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
                //�ֹ� �� DTO ���� (�߰��� "ono"�� �ֹ���ȣ)
                OrderDetailDTO detailDTO = new OrderDetailDTO(rs.getInt("dno"), rs.getInt("ono"), rs.getInt("pno"),
                        rs.getInt("price"), rs.getInt("amount"), rs.getString("d_option"), rs.getString("orderdt"));
                
                //��� DTO ���� (�߰��� "ono"�� �ֹ���ȣ)
                BasongDTO basongDTO = new BasongDTO(rs.getInt("ve_dno"), rs.getString("company"), rs.getString("shipnum"),
                        rs.getString("addr"), rs.getString("phone"), rs.getString("startdate"), rs.getInt("ono"), rs.getInt("status"));
                
                //OrderDTO�� �ҷ��� �� ��� �ְ� ����Ʈ�� ADD
                orderDTO = new OrderDTO(rs.getInt("ono"), rs.getString("userid"), rs.getString("paydt"),
                        rs.getInt("payment"), rs.getString("other"), detailDTO, basongDTO);
            }
        }finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return orderDTO;
    }
    
    
    /**
     * �ֹ� ����
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
     * ���� �������� ��������
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
     * �ֹ����� ����
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int orderUpdate(OrderDTO dto) throws SQLException {

        return 0;
    }

    /**
     * �ֹ� ���(����)
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
