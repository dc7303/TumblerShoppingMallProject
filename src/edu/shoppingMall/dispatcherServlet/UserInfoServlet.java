package edu.shoppingMall.dispatcherServlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 유저관리 Dispatcher Servlet입니다.
 * 관리자와 유저 영역에서 공동으로 사용하는 프로세서입니다.
 * @author mark
 *
 */
@WebServlet("/front")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
