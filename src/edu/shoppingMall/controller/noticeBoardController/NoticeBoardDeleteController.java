package edu.shoppingMall.controller.noticeBoardController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.service.NoticeBoardService;
import edu.shoppingMall.service.impl.NoticeBoardServiceImpl;

public class NoticeBoardDeleteController implements Controller {
    
    /**
     * 공지사항 삭제 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
    		ModelAndView mv = new ModelAndView();
    		
    		
    		int noticeBoardNum = Integer.parseInt(request.getParameter("noticeBoardNum"));
    		
    		try {
    			 service.noticeBoardDelete(noticeBoardNum);
    			 
    	     mv.setPath("frontNotice?command=noticeSelectAll");
    		 mv.setRedirect(true);
    		 
    		}catch (SQLException e) {
    			e.printStackTrace();
    			request.setAttribute("errorMsg", e.getMessage());
    		}
    		
    		return mv;
    }

}
