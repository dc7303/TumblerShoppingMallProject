package edu.shoppingMall.controller.qnaBoardController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.service.QnABoardService;
import edu.shoppingMall.service.impl.QnABoardServiceImpl;

public class QnABoardDeleteController implements Controller {
    
    /**
     * QnA 게시판 삭제 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    		String url = "qna?command=qnaSelectAll";
   			String qnaBoardUserId = request.getParameter("qnaBoardUserId");
   			System.out.println(qnaBoardUserId);
    		QnABoardService service = new QnABoardServiceImpl();
    		try {
    			service.qnaBoardDelete(qnaBoardUserId.trim());
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

    		ModelAndView mv = new ModelAndView();
    		mv.setPath(url);
    			
    		return mv;
    }

}
