package edu.shoppingMall.controller.productController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.ProductDTO;
import edu.shoppingMall.service.ProductInfoService;
import edu.shoppingMall.service.impl.ProductInfoServiceImpl;

public class ProductUpdateFormController implements Controller {

	@Override
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductInfoService service = ProductInfoServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
        
String url = "product/productSelectAllResult.jsp";
		
		String pno = request.getParameter("pno");
		
		try {
			ProductDTO dto = service.productSelectByProductNum(Integer.parseInt(pno));
			request.setAttribute("dto", dto);
			url="product/productUpdateResult.jsp";
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		mv.setPath(url);
		return mv;
	}

}
