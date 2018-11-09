package edu.shoppingMall.controller.noticeBoardController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.NoticeBoardDTO;
import edu.shoppingMall.service.NoticeBoardService;
import edu.shoppingMall.service.impl.NoticeBoardServiceImpl;

public class NoticeBoardUpdateController implements Controller{
    
    /**
     * 공지사항 수정 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ModelAndView  mv =new ModelAndView();
    	String url ="errorView/error.jsp";
    	NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
    	int noticeBoardNum = Integer.parseInt(request.getParameter("NoticeNum"));
		 String title = request.getParameter("title");
		 String content = request.getParameter("content");
    	
    	try {
			if(title==null || title.equals("") ||
					content==null || content.equals("")){
				  throw new SQLException("입력값이 충분하지 않습니다.");
			}
			NoticeBoardDTO dto = new NoticeBoardDTO(noticeBoardNum,title,content);
        	
			service.noticeBoardUpdate(dto);
			
			url="frontNotice?command=noticeRead&noticeBoardNum="+noticeBoardNum;
			mv.setRedirect(true);
			
			  }catch (SQLException e) {
				  e.printStackTrace();
				  request.setAttribute("errorMsg", e.getMessage());
			}
			
    	
    	mv.setPath(url);
		
		return mv;
    }
 

}
