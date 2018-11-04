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
import edu.shoppingMall.controller.modelAndView.ModelAndView;

/**
 * 유저관리 Dispatcher Servlet입니다.
 * 관리자와 유저 영역에서 공동으로 사용하는 프로세서입니다.
 * @author mark
 *
 */
@WebServlet("/frontUserInfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Controller> map;
	
	public void init(ServletConfig config) throws ServletException {
	    ServletContext application = config.getServletContext();
        
	    map = (Map<String, Controller>)application.getAttribute("map");
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String command = request.getParameter("command");
	    
	    ModelAndView modelAndView = map.get(command).service(request, response);

	    if(modelAndView.isRedirect()) {
	        response.sendRedirect(modelAndView.getPath());
	    }else {
	        request.getRequestDispatcher(modelAndView.getPath()).forward(request, response);
	    }
	}
}
