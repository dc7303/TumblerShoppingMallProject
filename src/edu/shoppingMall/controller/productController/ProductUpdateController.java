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
        
        int result = 0;
        try {
            result = service.productUpdate(new ProductDTO(0, proName, proInfo, proPrice, proCategory, proPicture, proBrand));
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
