package edu.shoppingMall.controller.productController;

import java.io.IOException;
import java.sql.SQLException;
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

public class ProductSelectAllController implements Controller {
    
    /**
     * 메뉴 전체조회 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductInfoService service = ProductInfoServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
        ServletContext application = request.getServletContext();
        
        String url = "/failMessage/failMessage.jsp";
        try {
            List<ProductDTO> list = service.productSelectAll();
            application.setAttribute("list", list);
            url = "/product/product.jsp";
        }catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        
        mv.setPath(url);
        return mv;
    }

}
