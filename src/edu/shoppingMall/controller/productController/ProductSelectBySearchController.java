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
        
    	String url = "product/productSelectAllResult.jsp";
		String keyType = request.getParameter("keyType");
		String keyWord = request.getParameter("keyWord");
		
		try {
			System.out.println(keyType);
			System.out.println(keyWord);
			
			List<ProductDTO> list = service.productSelectBySearch(keyType, keyWord);
			request.setAttribute("list", list);
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		mv.setPath(url);
		return mv;
	}
}
