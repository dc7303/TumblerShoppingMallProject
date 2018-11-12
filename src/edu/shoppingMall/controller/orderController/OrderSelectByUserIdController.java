package edu.shoppingMall.controller.orderController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.shoppingMall.controller.Controller;
import edu.shoppingMall.controller.modelAndView.ModelAndView;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.dto.UserInfoDTO;
import edu.shoppingMall.service.OrderService;
import edu.shoppingMall.service.impl.OrderServiceImpl;

public class OrderSelectByUserIdController implements Controller{

    /**
     * �ֹ� �������̵� �˻� ��Ʈ�ѷ�
     */
    @Override
    public ModelAndView service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderService service = OrderServiceImpl.getInstance();
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        
        String url = "/orderInfo/failView.jsp";
        
        UserInfoDTO userDTO = (UserInfoDTO)session.getAttribute("userDTO");    //���ǿ� ��������
        String userId = userDTO.getUserId();                    //�������̵�
        String whereGo = request.getParameter("search");        //��� ��ȸ�� �Դ��� �ľ��ϱ� ���� ����
        String basongFlag = request.getParameter("basongFlag"); //��� �÷��װ� use�� ��� ��ۻ��� 3(��ۿϷ�)�� ������ ��ǰ ��ȸ.
        try {
            List<OrderDTO> list = service.orderSelectByUserId(userId, basongFlag);//�׽�Ʈ��. ���� ���ǰ� �޾ƿͼ� �Ű����� �����ؾ���.
            url = "/orderInfo/myPage.jsp";
            request.setAttribute("orderList", list);
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", e.getMessage());
        }
        mv.setPath(url);

        return mv;
    }

}
