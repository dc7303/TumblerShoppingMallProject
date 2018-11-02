package edu.shoppingMall.util;
/**
 * DB������ ���� �ε�, ����, �ݱ� ��� Ŭ����
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


/**
 * �����ͺ��̽� ���� ��ƿ�Դϴ�.
 * META-INF/context.xml���� Resource�� ����Ͽ� ����ϰ� �ֽ��ϴ�.
 * �����ͺ��̽� ������ �ȵ� �� context.xml���� <Resource>�±׿���
 * username, password�� ���� Ȯ�����ּ���.
 * @author mark
 *
 */
public class DBUtil {
    static DataSource ds;
	/**
	 * �ε�
	 */
	static {	//���κ��ٵ� ���� ����ȴ�.
        try {
            Context initContext = new InitialContext();
            ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
            
            Connection conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
	
	/**
	 * ����
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	/**
	 * �ݱ� (insert, update, delete�� ���)
	 */
	public static void dbClose(Statement st, Connection con) {
		try {
			if(st != null) st.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ݱ� (select�� ���)
	 */
	public static void dbClose(ResultSet rs, Statement st, Connection con) {
		try {
			if(rs != null) rs.close();
			dbClose(st, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
