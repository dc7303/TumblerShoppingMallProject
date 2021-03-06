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

public class QnABoardReadController implements Controller {

    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        QnABoardService service = QnABoardServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
        String url = "errorview/error.jsp";
        int qnaBoardQno = Integer.parseInt(request.getParameter("qnaBoardQno"));

        try {

            QnABoardDTO dto = service.qnaBoardSelectByNo(qnaBoardQno);
            request.setAttribute("dto", dto);
            url = "qna/qnaRead.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }

        mv.setPath(url);
        return mv;

    }
}
