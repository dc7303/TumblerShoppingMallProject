package edu.shoppingMall.controller.basketController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.BasketDTO;
import edu.shoppingMall.dto.ProductDTO;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.BasketService;
import edu.shoppingMall.service.ProductInfoService;
import edu.shoppingMall.service.impl.BasketServiceImpl;
import edu.shoppingMall.service.impl.ProductInfoServiceImpl;

public class BasketInsertController implements Controller {

    /**
     * 장바구니 추가 컨트롤러
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	BasketService basketService = BasketServiceImpl.getInstance();
    	ModelAndView  mv =new ModelAndView();
    	
    	UserInfoDTO userDTO= (UserInfoDTO)request.getSession().getAttribute("userDTO");
    	
    	String userid = userDTO.getUserId();
    	int proNum= Integer.parseInt(request.getParameter("proNum"));
    	String option = request.getParameter("option");
    	int amount = Integer.parseInt(request.getParameter("amount"));
    	int totalPrice= Integer.parseInt(request.getParameter("proPrice")) * amount;
    	
        try {
        	
        	BasketDTO dto = new BasketDTO(0, proNum,userid, option, amount, totalPrice);
        	basketService.basketInsert(dto);
        	
        	}catch(SQLException e){
        		e.getStackTrace();
        	}
    		mv.setPath("frontBasket?command=basketByUserID");
    		mv.setRedirect(true);
    		return mv;
      
    }
    	}
