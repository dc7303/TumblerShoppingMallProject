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
/***
 * 업데이트 폼 추가
 * (수정 및 삭제 할 수 있는 페이지)
 *
 */


public class NoticeBoardUpdateFormController implements Controller {

	@Override
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
		 ModelAndView mv = new ModelAndView();
		 String url="errorView/error.jsp";

		 int noticeBoardNum = Integer.parseInt(request.getParameter("noticeBoardNum"));
         
         try {
        	 request.setAttribute("noticeDto", service.selectByNoticeNum(noticeBoardNum));;
        	 url="notice/NoticeUpdate.jsp";//수정폼
        	 
         }catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
         
        mv.setPath(url);
		return mv;
	}

}



