package edu.shoppingMall.controller.basketController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.BasketDTO;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.BasketService;
import edu.shoppingMall.service.impl.BasketServiceImpl;

public class BasketDeleteByBasketNumController implements Controller {

    /**
     * 장바구니 삭제 컨트롤러
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BasketService basketService = BasketServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
        
        int basketNum = Integer.parseInt(request.getParameter("basketNum"));
        
        String url = "frontBasket?command=basketByUserID&flag=no";      //실패시
        try {
            basketService.basketDeleteByBasketNum(basketNum);
            url = "frontBasket?command=basketByUserID&flag=no";
        } catch (SQLException e) {
            e.getStackTrace();
        }
        mv.setPath("frontBasket?command=basketByUserID&flag=no");
        mv.setRedirect(true);
        return mv;

    }

}
