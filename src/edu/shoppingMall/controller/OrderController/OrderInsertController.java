package edu.shoppingMall.controller.orderController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.OrderService;
import edu.shoppingMall.service.impl.OrderServiceImpl;

public class OrderInsertController implements Controller {
    
    /**
     * 주문 추가 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService service = OrderServiceImpl.getInstance();
        
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        UserInfoDTO userDTO = (UserInfoDTO)session.getAttribute("userDTO");
        int proNum = Integer.parseInt(request.getParameter("proNum"));
        int basongNum = Integer.parseInt(request.getParameter("basongNum"));
        String userId = userDTO.getUserId();
        int proQuantity = Integer.parseInt(request.getParameter("proQuantity"));
        String option = request.getParameter("option");
        String basongAddr = request.getParameter("basongAddr");
        String basongPhone = request.getParameter("basongPhone");
        String coment = request.getParameter("coment");
        String payment = request.getParameter("payment");
        
        String url = "/failView/failMessage.jsp";
        
        try {
            service.orderInsert(new OrderDTO(0, proNum, userId, basongNum, proQuantity,
                    option, basongAddr, basongPhone, coment, payment));
            url = "/order/orderSuccess.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        mv.setPath(url);
        return mv;
    }

}
