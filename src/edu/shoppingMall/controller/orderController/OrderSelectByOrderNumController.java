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
        HttpSession session = request.getSession();
        
        String url = "errorview/error.jsp";
        
        int orderNum = Integer.parseInt(request.getParameter("orderNum"));          //주문번호 파라미터
        
        try {
            OrderDTO orderDTO = service.orderSelectByOrderNum(orderNum);//테스트용. 추후 세션값 받아와서 매개변수 전달해야함.
            url = "/orderInfo/basongSearchResult.jsp";
            request.setAttribute("orderDTO", orderDTO);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        mv.setPath(url);

        return mv;
    }

}
