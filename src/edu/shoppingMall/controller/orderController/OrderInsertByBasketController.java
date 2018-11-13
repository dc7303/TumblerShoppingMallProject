package edu.shoppingMall.controller.orderController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.BasongDTO;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.dto.OrderDetailDTO;
import edu.shoppingMall.service.OrderService;
import edu.shoppingMall.service.impl.OrderServiceImpl;

public class OrderInsertByBasketController implements Controller {

    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderService service = OrderServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();

        //주문테이블 영역
        String userId = request.getParameter("userId");         //유저아이디
        String comment = request.getParameter("comment");       //배송 코멘트
        
        //배송테이블 영역
        String company = request.getParameter("company");
        String shipNum = request.getParameter("shipNum");
        String addr = request.getParameter("addr");
        String phone = request.getParameter("phone");
        BasongDTO basongDTO = new BasongDTO(company, shipNum, addr, phone);
        
        String url = "errorview/error.jsp";

        try {
            service.orderInsertByBasket(userId, comment, basongDTO);
            url = "/order/orderInsertSuccess.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        mv.setPath(url);
        return mv;
    }

}
