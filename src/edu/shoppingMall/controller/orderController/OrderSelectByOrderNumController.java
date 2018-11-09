package edu.shoppingMall.controller.orderController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.service.OrderService;
import edu.shoppingMall.service.impl.OrderServiceImpl;

public class OrderSelectByOrderNumController implements Controller {

    /**
     * 주문 주문번호로 조회 컨트롤러
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderService service = OrderServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
        
        int orderNum = Integer.parseInt(request.getParameter("orderNum"));
        
        String url = "/order/failView.jsp";
        try {
            OrderDTO orderDTO = service.orderSelectByOrderNum(orderNum);
            url = "/order/orderSelectByOrderNum.jsp";
            request.setAttribute("orderDTO", orderDTO);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        mv.setPath(url);

        return mv;
    }

}
