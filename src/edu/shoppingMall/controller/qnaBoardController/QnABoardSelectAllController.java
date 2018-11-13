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



public class QnABoardSelectAllController implements Controller {
    
    /**
     * QnA �Խ��� ��ü�˻� Controller
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		QnABoardService service = QnABoardServiceImpl.getInstance();
    	String url = "qna/qnaSelectAll.jsp"; //default��
		try {
				
				List<QnABoardDTO>list =service.qnaBoardSelectAll();
				request.setAttribute("list", list);
		}catch (Exception e) {
			e.printStackTrace(); //�ֿܼ� ���
			url = "errorview/error.jsp";
		}
			ModelAndView mv = new ModelAndView();
			mv.setPath(url);  //�����ص� �����ص� forward���
			return mv;
	 	
       }
     }


