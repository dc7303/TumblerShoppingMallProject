package edu.shoppingMall.controller.qnaBoardController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.QnABoardDTO;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.QnABoardService;
import edu.shoppingMall.service.impl.QnABoardServiceImpl;



public class QnABoardInsertController implements Controller{

	/**
	 * QnA 게시판 등록 Controller
	 */
	@Override
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		QnABoardService service = QnABoardServiceImpl.getInstance();
		ModelAndView mv = new ModelAndView();
		String url = "error/errorView.jsp";
		HttpSession session = request.getSession();
		
		String path = request.getServletContext().getRealPath("qna/save");
		int maxSize=1024*1024*100;
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request,path,maxSize,encoding, new DefaultFileRenamePolicy());
		

		//전송된 데이터 받기
		String title=  m.getParameter("qnaBoardSubject");
		String content = m.getParameter("qnaBoardContent");
		String pwd = m.getParameter("qnaBoardPwd");
		String photo = m.getFilesystemName("qnaBoardPhoto");
		UserInfoDTO userDTO = (UserInfoDTO)session.getAttribute("userDTO");
		String userId = userDTO.getUserId();
				//m.getParameter("qnaBoardUserId");
		
		QnABoardDTO dto = new QnABoardDTO(title,content,pwd,userId,photo);
		

		try {
			service.qnaBoardInsert(dto);
			url = "frontQna";
			mv.setRedirect(true);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		mv.setPath(url);
		return mv;
	}

}
