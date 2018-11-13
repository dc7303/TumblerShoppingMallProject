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
     * ���� ȸ������ controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfoService service = UserInfoServiceImpl.getInstance();

        String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userBirth = request.getParameter("userBirth");
        String userPhone = request.getParameter("userPhone");
        String userAddr = request.getParameter("userAddr");
        String userEmail = request.getParameter("userEmail");
        
        
        ModelAndView mv = new ModelAndView();
        String url = "errorview/error.jsp";

        /**
         * userAdminFlag 0: �Ϲ�ȸ��(�⺻��) , 1: ������
         *  userSignUpFlag 0: ȸ������(�⺻��),1: ȸ��Ż��
         */
        try {
            service.signUp(new UserInfoDTO(userId, userName, userPwd, userBirth, userPhone, userAddr,
                    userEmail, 0, 0, null));              
            url = "user/signUpResult.jsp";
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        mv.setPath(url);
        return mv;
    }

}
