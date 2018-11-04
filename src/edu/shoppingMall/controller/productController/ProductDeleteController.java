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
        
        int proNum = Integer.parseInt(request.getParameter("proNum"));
        
        int result = 0;
        try {
            result = service.productDelete(proNum);
            if(result > 0) {
                mv.setPath("?command=productSelectAll");
            }else {
                mv.setPath("/failMessage/failMessage.jsp");
                mv.setRedirect(true);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mv;
    }

}
