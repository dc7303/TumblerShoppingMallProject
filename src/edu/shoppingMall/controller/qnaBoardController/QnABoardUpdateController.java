package edu.shoppingMall.controller.qnaBoardController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.QnABoardDTO;
import edu.shoppingMall.service.QnABoardService;
import edu.shoppingMall.service.impl.QnABoardServiceImpl;

public class QnABoardUpdateController implements Controller {

	/**
	 * QnA �Խ��� ���� Controller
	 */
	@Override
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		QnABoardService service = QnABoardServiceImpl.getInstance();
		ModelAndView mv = new ModelAndView();
		String url = "qna/update.jsp";
		String qnaBoardQno = request.getParameter("qnaBoardQno");
		String qnaBoardSubject = request.getParameter("qnaBoardSubject");
		String qnaBoardContent = request.getParameter("qnaBoardContent");
		try {
			if (
					qnaBoardQno==null ||qnaBoardQno.equals("") ||
			qnaBoardSubject == null || qnaBoardSubject.equals("") || 
			qnaBoardContent == null|| qnaBoardContent.equals("")) {
				throw new SQLException("�Է°��� ������� �ʽ��ϴ�.");
			}
			
			QnABoardDTO dto = new QnABoardDTO(Integer.parseInt(qnaBoardQno),qnaBoardSubject, qnaBoardContent);
			
			
			service.qnaBoardUpdate(dto);
			url = "frontQna?command=qnaRead&qnaBoardQno="+qnaBoardQno;

		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}

		mv.setPath(url);
		return mv;
	}
}
