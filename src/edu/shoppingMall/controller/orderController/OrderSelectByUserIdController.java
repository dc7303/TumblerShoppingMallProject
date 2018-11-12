package edu.shoppingMall.controller.orderController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

public class OrderSelectByUserIdController implements Controller{

    /**
     * 주문 유저아이디 검색 컨트롤러
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderService service = OrderServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        
        String url = "/orderInfo/failView.jsp";
        
        UserInfoDTO userDTO = (UserInfoDTO)session.getAttribute("userDTO");    //세션에 가져오기
        String userId = userDTO.getUserId();                    //유저아이디
        String whereGo = request.getParameter("search");        //어디서 조회가 왔는지 파악하기 위한 변수
        String basongFlag = request.getParameter("basongFlag"); //배송 플레그가 use일 경우 배송상태 3(배송완료)를 제외한 상품 조회.
        try {
            List<OrderDTO> list = service.orderSelectByUserId(userId, basongFlag);//테스트용. 추후 세션값 받아와서 매개변수 전달해야함.
            url = "/orderInfo/myPage.jsp";
            request.setAttribute("orderList", list);
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        mv.setPath(url);

        return mv;
    }

}
