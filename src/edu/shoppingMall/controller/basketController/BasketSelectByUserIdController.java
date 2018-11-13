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
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.BasketService;
import edu.shoppingMall.service.impl.BasketServiceImpl;

public class BasketSelectByUserIdController implements Controller {

    /**
     * 장바구니 유저아이디로 조회 컨트롤러
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	BasketService service = BasketServiceImpl.getInstance();
    	ModelAndView  mv =new ModelAndView();
    	 String url="basket/BasketSelectById.jsp";
    	 UserInfoDTO userDTO =(UserInfoDTO)request.getSession().getAttribute("userDTO");
    	 String flag = request.getParameter("flag");
    	 request.setAttribute("flag", "basket");
    	 if(flag.equals("pay")) {
    		 url="orderInfo/buyForm.jsp";
    	 }
    	try {
	    	List<BasketDTO> list = service.basketSelectByUserId(userDTO.getUserId());
	    	request.setAttribute("list", list);
    	} catch (SQLException e) {
    		e.printStackTrace();
    		url="errorView/error.jsp";
    	}
    	
		mv.setPath(url);
		return mv;
    }
}
