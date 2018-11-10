package edu.shoppingMall.controller.qnaBoardController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.QnABoardDTO;
import edu.shoppingMall.service.QnABoardService;
import edu.shoppingMall.service.impl.QnABoardServiceImpl;



public class QnABoardSelectAllController implements Controller {
    
    /**
     * QnA 게시판 전체검색 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String url = "qna/list.jsp"; //default로
		try {
				
				//전체검색기능
			  QnABoardService service =  new QnABoardServiceImpl();
				List<QnABoardDTO>list =service.qnaBoardSelectAll();
				request.setAttribute("list", list);
		}catch (Exception e) {
			e.printStackTrace(); //콘솔에 출력
			url = "qna/error.jsp";
		}
			ModelAndView mv = new ModelAndView();
			mv.setPath(url);  //성공해도 실패해도 forward방식
			return mv;
	 	
       }
     }


