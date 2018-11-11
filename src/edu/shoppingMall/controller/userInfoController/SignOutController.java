package edu.shoppingMall.controller.userInfoController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;

public class SignOutController implements Controller {
    
    /**
     * 유저 로그아웃 controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getSession().invalidate();
    	ModelAndView mv = new ModelAndView();
    	mv.setPath("index.html");
    	mv.setRedirect(true);
    	return mv;
    }

}
