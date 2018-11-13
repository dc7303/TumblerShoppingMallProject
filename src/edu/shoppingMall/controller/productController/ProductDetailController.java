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

public class ProductDetailController implements Controller {

	@Override
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductInfoService service = ProductInfoServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
        
        String url="errorview/error.jsp";
		String pno = request.getParameter("pno");
		try {
			ProductDTO dto = service.productSelectByProductNum(Integer.parseInt(pno));
			request.setAttribute("dto", dto);
			String path = request.getServletContext().getRealPath("product/save");
			
			request.setAttribute("photoPath",path);
			url = "product/productRead.jsp";
			
		}catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		mv.setPath(url);
		return mv;
	}
}
