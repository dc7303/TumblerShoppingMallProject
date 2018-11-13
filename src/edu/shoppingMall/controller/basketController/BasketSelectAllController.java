package edu.shoppingMall.controller.basketController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.BasketDTO;
import edu.shoppingMall.service.BasketService;
import edu.shoppingMall.service.impl.BasketServiceImpl;
import edu.shoppingMall.service.impl.NoticeBoardServiceImpl;

public class BasketSelectAllController implements Controller {

    /**
     * ��ٱ��� ��ü��ȸ ��Ʈ�ѷ�
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    	    	BasketService service = BasketServiceImpl.getInstance();
    	    	ModelAndView  mv =new ModelAndView();
    	    	 String url="basket/BasketSelectById.jsp";
    	    	 //System.out.println("��µ˴ϱ�");
    	    	try {
    		    	List<BasketDTO> list = service.basketSelectAll();
    				//System.out.println(list);
    		
    		    	request.setAttribute("list", list);
    		    	//�信�� �ڹٷ� ������ ���� getParameter(" key " );
    		    	//�ڹٿ��� ��� �����ٶ��� setAttribute("list",list);
    	    	} catch (SQLException e) {
    	    		e.printStackTrace();
    	    		url="errorView/error.jsp";
    	    	}
    	    	
    			mv.setPath(url);
    			return mv;
  
    }

}
