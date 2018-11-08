package edu.shoppingMall.controller.qnaBoardController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;

public class QnABoardDeleteController implements Controller {
    
    /**
     * QnA 게시판 삭제 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	System.out.println("수정");
    	return null;
    }

}
