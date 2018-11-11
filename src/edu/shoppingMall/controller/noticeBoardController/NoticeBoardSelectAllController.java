package edu.shoppingMall.controller.noticeBoardController;

import java.io.IOException;
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
     * pageNo = ���� ������ �ѹ�,1���� ������ �⺻�� 1
     * pageSize = ������ ũ��, ���ڵ� ���� �⺻�� 5
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	NoticeBoardService service = NoticeBoardServiceImpl.getInstance();
    	ModelAndView  mv =new ModelAndView();
    	 String url="notice/NoticeSelectAll.jsp";
    	 
    	 /*
    	  * ����¡ ó�� �κ�
    	  * */
    	 int pageNo = 0;
    	 int pageSize = 5;
    	 if(!(request.getParameter("pageNo") == null)) {
    		  pageNo = Integer.parseInt(request.getParameter("pageNo"));
    	 }
    	try {
    		
    	 	if (pageNo < 1) {
                pageNo = 1;
            }
       	 
            if (pageSize < 5 || pageSize > 15) {
                pageSize = 5;
            }
                int totalCount = service.getTotalCount();
                int lastPageNo = totalCount / pageSize;
                
                if ((totalCount % pageSize) > 0) {
                lastPageNo++;
            }
                
             //start index : (pageNo - 1) * pageSize
            //end index:  pageNo * pageSize
                
	    	List<NoticeBoardDTO> list = service.noticeBoardSelectAll(pageNo,pageSize);
	    	request.setAttribute("list", list);
	    	request.setAttribute("pageNo", pageNo);
	    	request.setAttribute("lastPageNo", lastPageNo);
    	} catch (Exception e) {
    		e.printStackTrace();
    		url="errorView/error.jsp";
    	}
    	
		mv.setPath(url);
		return mv;
    }
}
