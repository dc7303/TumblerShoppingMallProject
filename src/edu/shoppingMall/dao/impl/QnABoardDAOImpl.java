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
	 private static QnABoardDAOImpl qnaDAO = new QnABoardDAOImpl();
	    
	    public static QnABoardDAOImpl getInstance() {
	        return qnaDAO;
	    }	
	
	@Override
	public List<QnABoardDTO> qnaBoardSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QnABoardDTO> list = new ArrayList<>();
		try {
			con=DBUtil.getConnection();
			ps = con.prepareStatement("select * from tb_qna ");
			rs = ps.executeQuery();
			while(rs.next()) {
				QnABoardDTO dto = new  QnABoardDTO(
						rs.getInt("qno"),rs.getString("title"), rs.getString("content"),
						rs.getString("pwd"),rs.getString("regdt"),rs.getString("userid"), 
						rs.getString("photo"),rs.getInt("qno2"));
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
		String sql = "select * from tb_qna where ";
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
						rs.getInt("qno"),rs.getString("title"), rs.getString("content"),
						rs.getString("pwd"),rs.getString("regdt"), 
						rs.getString("userid"),rs.getString("photo"),rs.getInt("qno2"));
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
				("insert into tb_qna values(qna_seq.nextval,?,?,?,sysdate,?,0,?,null)");
		try{
			con=DBUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getQnaBoardSubject());
			ps.setString(2, dto.getQnaBoardContent());
			ps.setString(3, dto.getQnaBoardPwd());
			ps.setString(4, dto.getQnaBoardPhoto());
			ps.setString(5, dto.getQnaBoardUserId());

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
		String sql ="update tb_qna set title=?,content=? where qno=?";
		try{

			con=DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getQnaBoardSubject());
			ps.setString(2, dto.getQnaBoardContent());
			ps.setInt(3, dto.getQnaBoardQno());
			result = ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbClose( ps, con);
		}
		System.out.println(result);
		return result;

	}


	@Override
	public int qnaBoardDelete(int qno) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con=DBUtil.getConnection();
			ps = con.prepareStatement("delete from tb_qna where qno=?");
			ps.setInt(1, qno);
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

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		QnABoardDTO dto = null;
		
		String sql = "select * from tb_qna where qno=?";
		try {
			con=DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,no);
			rs=ps.executeQuery();
			while(rs.next()) {
				dto = new  QnABoardDTO(
						rs.getInt("qno"),rs.getString("title"), rs.getString("content"),
						rs.getString("pwd"),rs.getString("regdt"), 
						rs.getString("userid"),rs.getString("photo"),rs.getInt("qno2"));
			} 
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(rs, ps, con);
		}
		return dto;
	}
}


