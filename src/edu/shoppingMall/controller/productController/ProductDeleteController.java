package edu.shoppingMall.controller.productController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.ProductDTO;
import edu.shoppingMall.service.ProductInfoService;
import edu.shoppingMall.service.impl.ProductInfoServiceImpl;

public class ProductDeleteController implements Controller {
    
    /**
     * 메뉴 삭제 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductInfoService service = ProductInfoServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
        String url="errorview/error.jsp";
        
        String pno = request.getParameter("pno");
        
        try {
			if(pno==null || pno.equals("")) {
				throw new SQLException("삭제하시려는 상품번호가 잘못되었습니다.");
			}
			service.productDelete(Integer.parseInt(pno));
			url = "product";
			mv.setRedirect(true);
			
		}catch(SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
	
		mv.setPath(url);
		return mv;
	}
}

