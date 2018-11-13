package edu.shoppingMall.controller.userInfoController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.UserInfoService;
import edu.shoppingMall.service.impl.UserInfoServiceImpl;

public class UserUpdateController implements Controller {
    
    /**
     * 유저 회원정보 수정 controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfoService service = UserInfoServiceImpl.getInstance();
        HttpSession session = request.getSession();
        int result = 0;
        UserInfoDTO dto = (UserInfoDTO)request.getSession().getAttribute("userDTO");
        String userId = dto.getUserId();
        String userPwd = request.getParameter("userPwd");
        String userName = request.getParameter("userName");
        String userBirth = request.getParameter("userBirth");
        String userPhone = request.getParameter("userPhone");
        String userAddr = request.getParameter("userAddr");
        String userEmail = request.getParameter("userEmail");
        
        ModelAndView mv = new ModelAndView();
        String url = "errorview/error.jsp";
        try {
            UserInfoDTO userDTO = new UserInfoDTO(userId,userName,userPwd,userBirth,userPhone,userAddr,userEmail,0,0,null);
            service.userUpdate(userDTO); 
            session.setAttribute("userDTO", userDTO);
            url = "index.html";
            mv.setRedirect(true);
        }catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        
        mv.setPath(url);
        return mv;
    }

}
