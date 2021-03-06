package edu.shoppingMall.controller.qnaBoardController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.QnABoardDTO;
import edu.shoppingMall.service.QnABoardService;
import edu.shoppingMall.service.impl.QnABoardServiceImpl;

public class QnABoardSelectBySearchController implements Controller {
    
    /**
     * QnA 게시판 키워드 검색 Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		QnABoardService service = QnABoardServiceImpl.getInstance();
    	ModelAndView mv = new ModelAndView();
    	String url = "errorview/error.jsp";
    	String keyType = request.getParameter("keyType");
    	String keyWord = request.getParameter("keyWord");
    	
    	try {
    		System.out.println(keyType);
			System.out.println(keyWord);
			
			List<QnABoardDTO> list = service.qnaBoardSelectBySearch(keyType, keyWord);
			request.setAttribute("list", list);
			url = "qna/list.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		mv.setPath(url);
		return mv;
	
     
    }

}
