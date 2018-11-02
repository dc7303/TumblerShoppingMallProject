package edu.shoppingMall.util;
/**
 * DB연동을 위한 로드, 연결, 닫기 기능 클래스
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


/**
 * 데이터베이스 연결 유틸입니다.
 * META-INF/context.xml에서 Resource를 등록하여 사용하고 있습니다.
 * 데이터베이스 연결이 안될 시 context.xml에서 <Resource>태그에서
 * username, password를 먼저 확인해주세요.
 * @author mark
 *
 */
public class DBUtil {
    static DataSource ds;
	/**
	 * 로드
	 */
	static {	//메인보다도 먼저 실행된다.
        try {
            Context initContext = new InitialContext();
            ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
            
            Connection conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
	
	/**
	 * 연결
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	/**
	 * 닫기 (insert, update, delete인 경우)
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
	 * 닫기 (select인 경우)
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
