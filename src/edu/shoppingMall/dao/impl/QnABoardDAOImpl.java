package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.shoppingMall.dao.QnABoardDAO;
import edu.shoppingMall.dto.QnABoardDTO;
import edu.shoppingMall.util.DBUtil;





public class QnABoardDAOImpl implements QnABoardDAO {

	@Override
	public List<QnABoardDTO> qnaBoardSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QnABoardDTO> list = new ArrayList<>();
		try {
			con=DBUtil.getConnection();
			ps = con.prepareStatement("select * from qnaBoard ");
			rs = ps.executeQuery();
			while(rs.next()) {
				QnABoardDTO dto = new  QnABoardDTO(
						rs.getInt("qnaBoardQno"),rs.getString("qnaBoardSubject"), rs.getString("qnaBoardContent"),
						rs.getString("qnaBoardPwd"),rs.getString("qnaBoardDate"), 
						rs.getString("qnaBoardUserId"),0 );
						list.add(dto);
			}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.dbClose(rs, ps, con);
			}
			return list;
	}

	@Override
	public List<QnABoardDTO> qnaBoardSelectBySearch(String keyType, String keyWord) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QnABoardDTO> list= new ArrayList<>();
		String sql = "select * from qnaBoard where ";
		try {
			if(keyType.equals("qnaBoardQno")) {
				sql+="qnoBoardQno like ?";
			}else if(keyType.equals("qnaBoardSubject")) {
				sql+="qnaBoardSubject like ?";
			}else {
				sql+="qnaBoardContent like ?";
			}
			con=DBUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				QnABoardDTO dto = new QnABoardDTO(
						rs.getInt("qnoBoardQno"), 
						rs.getString("qnaBoardSubject"),
						rs.getString("qnaBoardContent"));
				list.add(dto);
			}
		}finally {
			DBUtil.dbClose(rs, ps, con);
		}
			
		return list;
	}

	@Override
	public int qnaBoardInsert(QnABoardDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = 
				("insert into qnaBoard values(qna_seq.nextval,?,?,?,sysdate,?)");
		try{
			con=DBUtil.getConnection();
			ps=con.prepareStatement(sql);
		//	ps.setInt(1, dto.getQnaBoardQno());
			ps.setString(1, dto.getQnaBoardSubject());
			ps.setString(2, dto.getQnaBoardContent());
			ps.setString(3, dto.getQnaBoardPwd());
			ps.setString(4, dto.getQnaBoardUserId());
			result = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		   DBUtil.dbClose(ps, con);
		}
		return result;
	}
	
	

	@Override
	public int qnaBoardUpdate(QnABoardDTO dto) throws SQLException {
		
		Connection con =null;
		PreparedStatement ps =null;
		int result =0;
		String sql ="update qnaBoard set qnaBoardSubject=?,qnaBoardContent=? where qnaBoardQno=?";
		try{
			
			con=DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			 System.out.println("test"+dto.getQnaBoardSubject());
			 ps.setString(1, dto.getQnaBoardSubject());
			ps.setString(2, dto.getQnaBoardContent());
			ps.setInt(3, dto.getQnaBoardQno());
			result = ps.executeUpdate();
		}finally{
			DBUtil.dbClose( ps, con);
		}
		System.out.println(result);
		return result;

	}
	

	@Override
	public int qnaBoardDelete(String qnaBoardUserId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con=DBUtil.getConnection();
			  ps = con.prepareStatement("delete from qnaBoard where qnaBoardUserId=?");
			  ps.setString(1, qnaBoardUserId);
			  result = ps.executeUpdate();
		}catch (Exception e) {
				e.printStackTrace();
		}finally {
			DBUtil.dbClose( ps, con);
		}
		return result;
	}

	@Override
	public QnABoardDTO qnaBoardSelectByNo(int no) throws SQLException {
		// TODO Auto-generated method stub
		// select * from qnaBoard where qno=?
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		QnABoardDTO dto = null;
		String sql = "select * from qnaBoard where qnaboardqno=?";
		try {
			con=DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,no);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto = new QnABoardDTO(rs.getInt("qnaBoardQno"), rs.getString("qnaBoardSubject"),rs.getString("qnaBoardContent"),
						rs.getString("qnaBoardDate"), rs.getString("qnaBoardPwd"),
						rs.getString("qnaBoardUserId"),0 );
			}
			}finally{
				DBUtil.dbClose(rs, ps, con);
			}
			return dto;
	}
}
	
	
