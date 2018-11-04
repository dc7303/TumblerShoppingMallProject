package edu.shoppingMall.controller.userByAdminController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.UserInfoService;
import edu.shoppingMall.service.impl.UserInfoServiceImpl;

public class UserSelectAllController implements Controller{
    
    /**
     * 관리자 유저 정보 전체 조회 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfoService service = UserInfoServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
       
        try {
            List<UserInfoDTO> list =  service.userSelectAll();
            if(list != null) {
                mv.setPath("/successView/signUpSuccess.jsp");
                mv.setRedirect(false);
            }else {
                mv.setPath("/failView/failMessage.jsp");
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mv;
    }
    
}
