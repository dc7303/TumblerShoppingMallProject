package edu.shoppingMall.controller.qnaBoardController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.QnABoardDTO;
import edu.shoppingMall.service.QnABoardService;
import edu.shoppingMall.service.impl.QnABoardServiceImpl;


public class QnABoardUpdateFormController implements Controller {
	private static QnABoardService service = new QnABoardServiceImpl();

	@Override
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ModelAndView mv = new ModelAndView();
		 String url="qna/read.jsp";
		 String qnaBoardQno= request.getParameter("qnaBoardQno");
		 System.out.println(qnaBoardQno);

		 try {
			 
		 	   QnABoardDTO dto = service.qnaBoardSelectByNo(Integer.parseInt(qnaBoardQno));
			 request.setAttribute("dto", dto);
			 	url="qna/update.jsp";
		
		 }catch (Exception e) {
			 e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
	
		mv.setPath(url);
	 	
		return mv;
	}

}
