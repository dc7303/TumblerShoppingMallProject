package edu.shoppingMall.controller.productController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
        
        String url = "errorview/error.jsp";
		
		String path = request.getServletContext().getRealPath("product/save");
		int maxSize=1024*1024*100;
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request,path,maxSize,encoding, new DefaultFileRenamePolicy());
		
		String pno = m.getParameter("pno");
		String pname = m.getParameter("pname");
		String info = m.getParameter("info");
		String price = m.getParameter("price");
		String category = m.getParameter("category");
		String photo = m.getFilesystemName("file");
		String brand = m.getParameter("brand");
		String stock = m.getParameter("stock");
	
		
		try {
			if(pno==null||pno.equals("")||
				pname==null||pname.equals("")||
				info==null||info.equals("")||
				price==null||price.equals("")||
				category==null||category.equals("")||
				brand==null||brand.equals("")||
				stock==null||stock.equals("")){
				throw new SQLException("입력값이 충분하지않습니다.");
			}
			
			//sss공격대비
			info = info.replaceAll("<", "&lt;");
			
			ProductDTO productdto = new ProductDTO(Integer.parseInt(pno), pname, info, Integer.parseInt(price), category,photo, brand, Integer.parseInt(stock));
					
			service.productInsert(productdto);
			url = "../ShoppingMallMVCExam/product?command=productSelectAll";
			mv.setRedirect(true);
			
				
		}catch(SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		mv.setPath(url);
		return mv;
	}

}
