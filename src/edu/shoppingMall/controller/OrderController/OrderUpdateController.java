package edu.shoppingMall.controller.orderController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.service.OrderService;
import edu.shoppingMall.service.impl.OrderServiceImpl;

public class OrderUpdateController implements Controller {
    
    /**
     * 주문 수정 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService service = new OrderServiceImpl();
        ModelAndView mv = new ModelAndView();
        
        int orderNum = Integer.parseInt(request.getParameter("orderNum"));
        int proNum = Integer.parseInt(request.getParameter("proNum"));
        String userId = request.getParameter("userId");
        System.out.println(userId);
        int basongNum = Integer.parseInt(request.getParameter("basongNum"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String option = request.getParameter("option");
        String basongAddr = request.getParameter("basongAddr");
        String basongPhone = request.getParameter("basongPhone");
        String coment = request.getParameter("coment");
        String payment = request.getParameter("payment");
        
        String url = "/failView/failMessage.jsp";
        try {
            service.orderUpdate(new OrderDTO(orderNum, proNum, userId, basongNum,
                    quantity, option, basongAddr, basongPhone, coment, payment));
            url = "/order/orderSuccess.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        mv.setPath(url);
        return mv;
    }

}
