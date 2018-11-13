package edu.shoppingMall.controller.noticeBoardController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.NoticeBoardDTO;
import edu.shoppingMall.service.NoticeBoardService;
import edu.shoppingMall.service.impl.NoticeBoardServiceImpl;

public class NoticeBoardInsertController implements Controller {
    
    /**
     * 공지사항 등록 Controller
     * 
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
    	
    	NoticeBoardDTO dto = new NoticeBoardDTO(0,request.getParameter("title"),request.getParameter("content"),null);
    	
    	ModelAndView  mv =new ModelAndView();
    	try {
    		service.noticeBoardInsert(dto);
    	} catch (Exception e) {
    		e.getMessage();
    	}
    	
		mv.setPath("frontNotice?command=noticeSelectAll");
		mv.setRedirect(true);
		return mv;
    }

}
