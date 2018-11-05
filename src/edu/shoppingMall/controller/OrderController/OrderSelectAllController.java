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

public class OrderSelectAllController implements Controller {
    
    /**
     * 주문내역 전체 조회 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService service = OrderServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
        String url = "failView/failMessage.jsp";
        try {
            List<OrderDTO> list = service.orderSelectAll();
            url = "/order/orderList.jsp";
            request.setAttribute("orderList", list);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        mv.setPath(url);
        return mv;
    }

}
