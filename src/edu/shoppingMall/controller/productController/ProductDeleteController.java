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
     * �޴� ���� Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductInfoService service = ProductInfoServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
        
        int proNum = Integer.parseInt(request.getParameter("proNum"));
        
        String url = "/failMessage/failMessage.jsp";
        try {
            service.productDelete(proNum);
            url = "?command=productSelectAll";
            mv.setRedirect(true);
        }catch(SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        
        mv.setPath(url);
        return mv;
    }

}
