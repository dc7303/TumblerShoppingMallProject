package edu.shoppingMall.dispatcherServlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;

/**
 * �������� Dispatcher Servlet�Դϴ�.
 * �����ڿ� ���� �������� �������� ����ϴ� ���μ����Դϴ�.
 * @author mark
 *
 */
@WebServlet("/frontUserInfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		
		Map<String, Controller> map = (Map<String, Controller>)application.getAttribute("map");
	    String command = request.getParameter("command");
	    
	    = map.get(command);
		request.getRequestDispatcher("").forward(request, response);
	}

}
