package edu.shoppingMall.controller.productController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.ProductDTO;
import edu.shoppingMall.service.ProductInfoService;
import edu.shoppingMall.service.impl.ProductInfoServiceImpl;

public class ProductSelectBySearchController implements Controller {
    
    /**
     * 메뉴 키워드검색 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ProductInfoService service = ProductInfoServiceImpl.getInstance();
    	ModelAndView mv = new ModelAndView();
        
    	String url = "errorview/error.jsp";
		String keyType = request.getParameter("keyType");
		String keyWord = request.getParameter("keyWord");
		
		try {
			List<ProductDTO> list = service.productSelectBySearch(keyType, keyWord);
			request.setAttribute("list", list);
			url = "product/productSelectAllResult.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		mv.setPath(url);
		return mv;
	}
}
