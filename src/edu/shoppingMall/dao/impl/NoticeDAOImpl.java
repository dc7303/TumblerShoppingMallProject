package edu.shoppingMall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.shoppingMall.dao.NoticeDAO;
import edu.shoppingMall.dto.NoticeBoardDTO;
import edu.shoppingMall.util.DBUtil;
import oracle.net.aso.p;

public class NoticeDAOImpl implements NoticeDAO {
    private static NoticeDAOImpl noticeDAO = new NoticeDAOImpl();
    
    public static NoticeDAOImpl getInstance() {
        return noticeDAO;
    }
    
    
    /**
     * �������� ��ü ��ȸ(����¡ ó��)
     * @return list
     * @throws SQLException
     * @param startIndex ���� �ε���
     * @param endIndex �� �ε���
     */
    @Override
    public List<NoticeBoardDTO> noticeBoardSelectAll(int startIndex,int endIndex) throws SQLException {
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<NoticeBoardDTO> list = new ArrayList<>();
		//�ε� ���� ���� �ݱ�
		try{
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from (select rownum num, nno, title,content,regdt from (select * from tb_notice order by nno)) where num between ? and ?");
			ps.setInt(1, startIndex);
			ps.setInt(2, endIndex);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new NoticeBoardDTO(rs.getInt("nno"),rs.getString("title"),rs.getString("content"),rs.getString("regdt")));
			}

		} finally {
			DBUtil.dbClose(rs, ps, con);
		}

		return list;
    }

    /**
     * �������� Ű���� �˻�
     * @param keyType
     * @param keyWord
     * @return
     * @throws SQLException
     */
    /*@Override
    public List<NoticeBoardDTO> noticeBoardSelectBySearch(String keyType, String keyWord) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
*/
    /**
     * �������� �߰�
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int noticeBoardInsert(NoticeBoardDTO dto) throws SQLException {

		Connection con=null;
		PreparedStatement ps =null;
		int result=0;
		String sql=
				"insert into tb_notice(nno,title,content,regdt) values(notice_seq.nextval,?,?,sysdate)";
		try {
			//�ε� ���� ���� �ݱ�
			con=DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getNoticeBoardSubject());
			ps.setString(2, dto.getNoticeBoardContent());
			result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose( ps, con);
		}
		return result;
	}
    

    /**
     * �������� ����
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public int noticeBoardUpdate(NoticeBoardDTO dto) throws SQLException {
    	Connection con =DBUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try{
			ps = con.prepareStatement("update tb_notice set "
					+ " title=?,content=?"
					+ "where nno=?");
			
			ps.setString(1, dto.getNoticeBoardSubject());
			ps.setString(2, dto.getNoticeBoardContent());
			ps.setInt(3, dto.getNoticeBoardNum());
			
			result = ps.executeUpdate();
		}finally{
			DBUtil.dbClose( ps, con);
		}
		return result;
    }

    /**
     * �������� ����
     * @param NoticeBoardNum
     * @return
     * @throws SQLException
     */
    @Override
    public int noticeBoardDelete(int NoticeBoardNum) throws SQLException {
    	Connection con=null;
		PreparedStatement ps =null;
		int result=0;
		String sql="delete from tb_notice where nno= ?";
		try {
			//�ε� ���� ���� �ݱ�
			con=DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,NoticeBoardNum );
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose( ps, con);
		}
		return result;
	
    }


	@Override
	public NoticeBoardDTO selectByNoticeNum(int NoticeBoardNum) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs =null;
		NoticeBoardDTO dto =null;
		try{
			 ps = con.prepareStatement( "select * from tb_notice where nno=?");
			 ps.setInt(1, NoticeBoardNum);
			 rs = ps.executeQuery();
			 if(rs.next()){
				 dto = new NoticeBoardDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));}
		}finally{
			DBUtil.dbClose(rs, ps, con);
		}
		return dto;
	}


	@Override
	public int selectCount() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result =0;
		//�ε� ���� ���� �ݱ�
		try{
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select count(*) totalcount from tb_notice");
			rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt("totalcount");
			}
		} finally {
			DBUtil.dbClose(ps, con);
		}
		return result;
	}

    
    
    
}
