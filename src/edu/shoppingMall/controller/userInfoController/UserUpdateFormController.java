package edu.shoppingMall.controller.userInfoController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.QnABoardDTO;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.QnABoardService;
import edu.shoppingMall.service.UserInfoService;
import edu.shoppingMall.service.impl.QnABoardServiceImpl;
import edu.shoppingMall.service.impl.UserInfoServiceImpl;

public class UserUpdateFormController implements Controller {
    
    /**
     * 유저 회원정보 수정 controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		 String url="errorview/error.jsp";
		 UserInfoDTO dto = (UserInfoDTO)request.getSession().getAttribute("userDTO");

		 try {
			 request.setAttribute("dto", dto);
			 url="user/userUpdate.jsp";
		
		 }catch (Exception e) {
			 e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
	
		mv.setPath(url);
	 	
		return mv;
    }

}
