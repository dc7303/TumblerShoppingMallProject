package edu.shoppingMall.controller.basketController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.BasketDTO;
import edu.shoppingMall.service.BasketService;
import edu.shoppingMall.service.impl.BasketServiceImpl;
import edu.shoppingMall.service.impl.NoticeBoardServiceImpl;

public class BasketSelectAllController implements Controller {

    /**
     * 장바구니 전체조회 컨트롤러
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    	    	BasketService service = BasketServiceImpl.getInstance();
    	    	ModelAndView  mv =new ModelAndView();
    	    	 String url="basket/BasketSelectById.jsp";
    	    	 //System.out.println("출력됩니까");
    	    	try {
    		    	List<BasketDTO> list = service.basketSelectAll();
    				//System.out.println(list);
    		
    		    	request.setAttribute("list", list);
    		    	//뷰에서 자바로 가져올 때는 getParameter(" key " );
    		    	//자바에서 뷰로 보내줄때는 setAttribute("list",list);
    	    	} catch (SQLException e) {
    	    		e.printStackTrace();
    	    		url="errorView/error.jsp";
    	    	}
    	    	
    			mv.setPath(url);
    			return mv;
  
    }

}
