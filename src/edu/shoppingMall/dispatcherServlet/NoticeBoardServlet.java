package edu.shoppingMall.dispatcherServlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;


/**
 * QnA 게시판 Dispatcher Servlet입니다
 * @author mark
 *
 */
@WebServlet("/frontNotice")
public class NoticeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String,Controller> map;


	public void init(ServletConfig config) throws ServletException {
		map = (Map<String, Controller>)config.getServletContext().getAttribute("map");
		System.out.println(map);
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key= request.getParameter("command");
		//System.out.println("key:"+key);
		//System.out.println("values:"+map.get(key));
		ModelAndView mv = map.get(key).service(request, response);
		if(mv.isRedirect()) {//redirect로 이동
			response.sendRedirect(mv.getPath());
		}else {request.getRequestDispatcher(mv.getPath()).forward(request, response);
		}	
	}

}
