package edu.shoppingMall.controller.noticeBoardController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.NoticeBoardDTO;
import edu.shoppingMall.service.NoticeBoardService;
import edu.shoppingMall.service.impl.NoticeBoardServiceImpl;

public class NoticeBoardReadController implements Controller {
/**
 *  �������� ���������� (�������� ���� Ȯ��) �߰�
 * 
 */
	@Override
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
		int noticeBoardNum = Integer.parseInt(request.getParameter("noticeBoardNum"));;
		String url = "errorView/error.jsp";

		try {
			// �󼼺��⸦ ���� �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
			NoticeBoardDTO noticeDto = service.selectByNoticeNum(noticeBoardNum);

			request.setAttribute("noticeDto", noticeDto);
			url = "notice/NoticeRead.jsp";

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}

		ModelAndView mv = new ModelAndView();
		mv.setPath(url);

		return mv;
	}

}
