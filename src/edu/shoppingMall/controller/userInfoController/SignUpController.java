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
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userBirth = request.getParameter("userBirth");
        String userPhone = request.getParameter("userPhone");
        String userAddr = request.getParameter("userAddr");
        String userEmail = request.getParameter("userEmail1") + "@" + request.getParameter("userEmail2");
        int userAdminFlag = Integer.parseInt(request.getParameter("userAdminFlag"));
        int userSignUpFlag = Integer.parseInt(request.getParameter("userSignUpFlag"));
        
        
        ModelAndView mv = new ModelAndView();
        String url = "/failView/failMessage.jsp";
        
        //DTO생성 되는 부분에 입력값 전달
        try {
            //DTO에서 null은 sql에서 sysdate로 입력되기 때문에 null을 넣어줌.
            service.signUp(new UserInfoDTO(userId, userName, userPwd, userBirth, userPhone, userAddr,
                    userEmail, userAdminFlag, userSignUpFlag, null));              
            url = "/successView/signUpSuccess.jsp";
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        mv.setPath(url);
        return mv;
    }

}
