package edu.shoppingMall.controller.userInfoController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.QnABoardService;
import edu.shoppingMall.service.UserInfoService;
import edu.shoppingMall.service.impl.QnABoardServiceImpl;
import edu.shoppingMall.service.impl.UserInfoServiceImpl;

public class UserDeleteController implements Controller {
    
    /**
     * À¯Àú È¸¿øÅ»Åð controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	UserInfoDTO userDTO = (UserInfoDTO)request.getSession().getAttribute("userDTO");
    	UserInfoService service = UserInfoServiceImpl.getInstance();
    	String url = "user/userDeleteResult.jsp";
    	String password= request.getParameter("password");
    	System.out.println(password);
    	System.out.println(userDTO);
    	userDTO.setUserPwd(password);
		
		try {
			service.userDelete(userDTO);
		} catch (SQLException e) {
			e.printStackTrace();
			url="errorview/error.jsp";
		}

		ModelAndView mv = new ModelAndView();
		mv.setPath(url);
		mv.setRedirect(true);
    	request.getSession().invalidate();
    	return mv;
    }

}
