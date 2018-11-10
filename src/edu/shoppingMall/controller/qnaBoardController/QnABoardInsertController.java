package edu.shoppingMall.controller.qnaBoardController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.QnABoardDTO;
import edu.shoppingMall.service.QnABoardService;
import edu.shoppingMall.service.impl.QnABoardServiceImpl;



public class QnABoardInsertController implements Controller{
    
    /**
     * QnA 게시판 등록 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	   String url = "qna";
    	     ModelAndView mv = new ModelAndView();
    
    	
    			//전송된 데이터 받기
    	     //	String qnaBoardQno = request.getParameter("qnaBoardQno");
    		 	String qnaBoardUserId = request.getParameter("qnaBoardUserId");
    		 	String qnaBoardSubject  =  request.getParameter("qnaBoardSubject");
    		 	String qnaBoardContent = request.getParameter("qnaBoardContent");
    		 	String qnaBoardPwd = request.getParameter("qnaBoardPwd");
    		 	
    		 
    		 	QnABoardDTO dto = new QnABoardDTO(0, qnaBoardSubject, qnaBoardContent, "sysdate", qnaBoardPwd, qnaBoardUserId, 0);

    			System.out.println(qnaBoardUserId + " " + qnaBoardSubject+" " +qnaBoardContent+" " +qnaBoardPwd);
    		  QnABoardService service =  new QnABoardServiceImpl();

    		try {
    				service.qnaBoardInsert(dto);
    				 mv.setRedirect(true); //insert는 무조건 redirect
    				 
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
   		   mv.setPath(url);
    	
			return mv;
    }

}
