package edu.shoppingMall.controller.basketController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.BasketDTO;
import edu.shoppingMall.service.BasketService;
import edu.shoppingMall.service.impl.BasketServiceImpl;

public class BasketInsertController implements Controller {

    /**
     * 장바구니 추가 컨트롤러
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	BasketService service = BasketServiceImpl.getInstance();
    	String userid="test1";
    	BasketDTO dto = new BasketDTO(0, 1002,"test1","testoption2", 5, 2000);
    	ModelAndView  mv =new ModelAndView();
        try {
        	service.basketInsert(dto);
        	
        	}catch(SQLException e){
        		e.getStackTrace();
        	}
    		mv.setPath("frontBasket?command=basketSelectAll");
    		mv.setRedirect(true);
    		return mv;
      
    }
    	}
