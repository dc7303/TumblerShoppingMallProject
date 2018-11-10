package edu.shoppingMall.controller.noticeBoardController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.NoticeBoardDTO;
import edu.shoppingMall.service.NoticeBoardService;
import edu.shoppingMall.service.impl.NoticeBoardServiceImpl;

public class NoticeBoardSelectAllController implements Controller {
    
    /**
     * �������� ��ü�˻� Controller
     * @return mv
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
    	ModelAndView  mv =new ModelAndView();
    	 String url="notice/NoticeSelectAll.jsp";
    	try {
	    	List<NoticeBoardDTO> list = service.noticeBoardSelectAll();
			
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
