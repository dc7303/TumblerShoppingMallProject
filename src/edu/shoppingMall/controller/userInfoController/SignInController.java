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
import edu.shoppingMall.service.UserInfoService;
import edu.shoppingMall.service.impl.UserInfoServiceImpl;

public class SignInController implements Controller {
    
    /**
     * 유저 로그인 controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfoService service = UserInfoServiceImpl.getInstance();
        ServletContext application = request.getServletContext();
        HttpSession session = request.getSession();
        
        String id = request.getParameter("userId");
        String pwd = request.getParameter("userPwd");
        
        ModelAndView mv = new ModelAndView();
        
        String path = application.getAttribute("contextPath").toString();

        try {
            boolean result = service.signIn(id, pwd);
            if(result) {
                session.setAttribute("userId", id);
                mv.setPath("/successView/loginSuccess.jsp");
                mv.setRedirect(false);
            }else {
                mv.setPath("/failView/failMessage.jsp");
                mv.setRedirect(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mv;
    }

}
