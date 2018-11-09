package edu.shoppingMall.controller.orderController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.BasongDTO;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.dto.OrderDetailDTO;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.OrderService;
import edu.shoppingMall.service.impl.OrderServiceImpl;

public class OrderInsertController implements Controller {

    /**
     * �ֹ� �߰� Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderService service = OrderServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();

        // TB_Order Table
        String userId = request.getParameter("userId");
        String orther = request.getParameter("orther");

        // TB_Detail Table
        int proNum= Integer.parseInt(request.getParameter("proNum"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String option = request.getParameter("option");
        
        // TB_Delivery
        String company = request.getParameter("company");
        String shipNum = request.getParameter("shipNum");
        String addr = request.getParameter("addr");
        String phone = request.getParameter("phone");

        OrderDetailDTO detailDTO = new OrderDetailDTO(proNum, amount, option);
        BasongDTO basongDTO = new BasongDTO(company, shipNum, addr, phone);
        
        
        String url = "/order/failView.jsp";

        try {
            service.orderInsert(new OrderDTO(userId, orther, detailDTO, basongDTO));
            url = "/order/orderInsertSuccess.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        mv.setPath(url);
        return mv;
    }

}
