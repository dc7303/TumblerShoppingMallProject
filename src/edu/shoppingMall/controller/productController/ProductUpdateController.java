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

public class ProductUpdateController implements Controller {
    
    /**
     * 메뉴수정 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductInfoService service = ProductInfoServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
        
        String proName = request.getParameter("proName");
        String proInfo = request.getParameter("proInfo");
        int proPrice = Integer.parseInt(request.getParameter("proPrice"));
        String proCategory = request.getParameter("proCategory");
        String proPicture = request.getParameter("proPicture");
        String proBrand = request.getParameter("proBrand");
        
        String url = "/failMessage/failMessage.jsp";
        try {
            service.productUpdate(new ProductDTO());
            url = "?command=productSelectAll";
        }catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        
        mv.setPath(url);
        return mv;
    }

}
