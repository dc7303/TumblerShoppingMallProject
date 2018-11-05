package edu.shoppingMall.controller.userInfoController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.UserInfoService;
import edu.shoppingMall.service.impl.UserInfoServiceImpl;

public class SignUpController implements Controller {
    
    /**
     * 유저 회원가입 controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfoService service = UserInfoServiceImpl.getInstance();

        int result = 0;
        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");
        String userName = request.getParameter("userName");
        String userBirth = request.getParameter("userBirth");
        String userAddr = request.getParameter("userAddr");
        String userEmail = request.getParameter("userEmail1") + "@" + request.getParameter("userEmail2");
        
        ModelAndView mv = new ModelAndView();
        String url = "/failView/failMessage.jsp";
        try {
            service.signUp(new UserInfoDTO(userId, userPwd, userName, userBirth, userAddr, userEmail, null));
            url = "/successView/signUpSuccess.jsp";
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        mv.setPath(url);
        return mv;
    }

}
