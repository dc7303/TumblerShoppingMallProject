package edu.shoppingMall.controller.userInfoController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.UserInfoService;
import edu.shoppingMall.service.impl.UserInfoServiceImpl;

public class SignInController implements Controller {
    
    /**
     * 유저 로그인 controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfoService service = UserInfoServiceImpl.getInstance();
        HttpSession session = request.getSession();
        
        String id = request.getParameter("userId");
        String pwd = request.getParameter("userPwd");
        
        ModelAndView mv = new ModelAndView();
        
        String url = "/failView/failMessage.jsp";
        try {
            UserInfoDTO dto = service.signIn(id, pwd);
            session.setAttribute("userDTO", dto);
            url = "/successView/loginSuccess.jsp";
        }catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        
        mv.setPath(url);
        return mv;
    }

}
