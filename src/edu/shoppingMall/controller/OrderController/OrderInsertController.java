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

public class OrderInsertController implements Controller {
    
    /**
     * 주문 추가 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService service = OrderServiceImpl.getInstance();
        
        ModelAndView mv = new ModelAndView();

        int proNum = Integer.parseInt(request.getParameter("proNum"));
        int basongNum = Integer.parseInt(request.getParameter("basongNum"));
        String userId = request.getSession().getAttribute("userId").toString();
        int proQuantity = Integer.parseInt(request.getParameter("proQuantity"));
        String option = request.getParameter("option");
        String basongAddr = request.getParameter("basongAddr");
        String basongPhone = request.getParameter("basongPhone");
        String coment = request.getParameter("coment");
        String payment = request.getParameter("payment");
        
        try {
            int result = service.orderInsert(new OrderDTO(0, proNum, userId, basongNum, proQuantity,
                    option, basongAddr, basongPhone, coment, payment));
            if(result > 0) {
                mv.setPath("/order/orderSuccess.jsp");
            }else {
                mv.setPath("/failView/failMessage.jsp");
                mv.setRedirect(true);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
