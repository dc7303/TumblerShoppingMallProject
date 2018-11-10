package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.BasketDAO;
import edu.shoppingMall.dao.BasongDAO;
import edu.shoppingMall.dao.OrderDAO;
import edu.shoppingMall.dao.OrderDetailDAO;
import edu.shoppingMall.dao.ProductInfoDAO;
import edu.shoppingMall.dao.impl.BasketDAOImpl;
import edu.shoppingMall.dao.impl.BasongDAOImpl;
import edu.shoppingMall.dao.impl.OrderDAOImpl;
import edu.shoppingMall.dao.impl.OrderDetailDAOImpl;
import edu.shoppingMall.dao.impl.ProductInfoDAOImpl;
import edu.shoppingMall.dto.BasketDTO;
import edu.shoppingMall.dto.BasongDTO;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.dto.OrderDetailDTO;
import edu.shoppingMall.dto.ProductDTO;
import edu.shoppingMall.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private static OrderServiceImpl service = new OrderServiceImpl();
    private OrderDAO orderDAO = OrderDAOImpl.getInstance();
    private OrderDetailDAO detailDAO = OrderDetailDAOImpl.getInstance();
    private BasongDAO basongDAO = new BasongDAOImpl().getInstance();
    private BasketDAO basketDAO = new BasketDAOImpl().getInstance();
    private ProductInfoDAO productDAO =  new ProductInfoDAOImpl().getInstance();
    
    public static OrderServiceImpl getInstance() {
        return service;
    }
    

    /**
     * �ֹ� ��ü �˻� (OrderDetailDTO�� BasongDTO�� ������ DTO�� �����Ѵ�.)
     * ������ �Ǹ� ���� Ȯ��.
     */
    @Override
    public List<OrderDTO> orderSelectAll() throws SQLException {
        List<OrderDTO> list = orderDAO.orderSelectAll();
        if(list == null) {
            throw new SQLException("�Ǹų����� �����ϴ�. �ٽ� Ȯ�����ּ���.");
        }
        return list;
    }
    
    /**
     * �ֹ� ��ȸ UserID�� ��ȸ�ϱ� ���ϰ��� (OrderDetailDTO�� BasongDTO�� ������ DTO�� �����Ѵ�.) ID�� �Ķ���ͷ�
     * �޾� �ֹ���, �ֹ� ���� ID�� ��ȸ ������ DAO �޼ҵ带 ����� �� �ִ�.
     * �� ���������� �ֹ����� Ȯ��
     * 
     * basongFlage �Ķ���ͷ� �ֹ�����, ���� �������� �и��ؼ� ��밡��.
     */
    @Override
    public List<OrderDTO> orderSelectByUserId(String userId, String basongFlag) throws SQLException {
        List<OrderDTO> list = orderDAO.orderSelectByUserId(userId, basongFlag);
        if(list == null) {
            throw new SQLException("�ֹ��Ͻ� ������ �����ϴ�.");
        }
        return list;
    }

    /**
     * �ֹ���ȣ�� �˻��ϱ� (OrderDetailDTO�� BasongDTO�� ������ DTO�� �����Ѵ�.) �ֹ���ȣ�� �Ķ���ͷ� �޾� ���,
     * �ֹ���, �ֹ� ���� �ֹ���ȣ�� ��ȸ ������ DAO �޼ҵ带 ����� �� �ִ�.
     * �ֹ� �󼼳��� Ȯ��
     */
    @Override
    public OrderDTO orderSelectByOrderNum(int orderNum) throws SQLException {
        OrderDTO orderDTO = orderDAO.orderSelectByOrderNum(orderNum);
        if(orderDTO == null) {
            throw new SQLException("�˻��Ͻ� �ֹ���ȣ�� ���� ��ȣ�Դϴ�.");
        }
        return orderDTO;
    }

    /**
     * �ֹ� ���� ���� ����
     * ���μ��� ����. ��ǰ���ݺҷ��� - > �ֹ����� -> �ֹ��� ���� -> ��� ����
     * ��ǰ������ productSelectByProNum �޼ҵ带 �̿��� �����ͼ� ������ ���� �� �ֹ� �󼼿� �ֹ� ���ݿ� �������ش�.
     */
    @Override
    public int orderInsert(OrderDTO dto) throws SQLException {
        ProductInfoDAO proDAO = ProductInfoDAOImpl.getInstance();
        OrderDetailDTO detailDTO = dto.getDetailDTO();
        BasongDTO basongDTO = dto.getBasongDTO();
        int proNum = detailDTO.getProductNum();
        
        ProductDTO proDTO = proDAO.productSelectByProductNum(detailDTO.getProductNum());    //��ǰ��ȣ �Է�
        if(proDTO == null) {
            throw new SQLException("�ֹ� ��û�Ͻ� ��ǰ�� �������� �ʽ��ϴ�");
        }else if (proDTO.getProductQuantity() == 0) {
            throw new SQLException("�ֹ��Ͻ� ��ǰ�� ��� �����ϴ�.");
        }
        
        int price = proDTO.getProductPrice();                   //��ǰ����
        int amount = detailDTO.getOrderDetailQuantity();        //�ֹ�����
        int orderPrice = price * amount;            //�ֹ� �� ����, �ֹ� ����
        
        //Order ����(�������� �Ű������� ����)
        System.out.println("����");
        int orderResult = orderDAO.orderInsert(new OrderDTO(dto.getOrderUserId(), dto.getOrderComment(), orderPrice));
        if(orderResult == 0) {
            throw new SQLException("�ֹ� ������ ��ġ���� �ʽ��ϴ�.");
        }
        
        int orderNum = orderDAO.orderSeqSearch();               //������ ������ �ֹ� �������� ��������.
         
        //OrderDetail ����
        detailDTO.setOrderNum(orderNum);                                            //�ֹ���ȣ����
        detailDTO.setOrderDetailPrice(orderPrice);                                  //�� ���� ����
        int detailResult = detailDAO.orderDetailInsert(detailDTO);
        if(detailResult == 0) {
            orderDAO.orderDelete(orderNum);                                         //���н� order���̺� ����
            throw new SQLException("�ֹ� �� ������ �߸��ƽ��ϴ�.");
        }
        
        //Delivery ����
        basongDTO.setOrderNum(orderNum);                   //�ֹ���ȣ����
        int basongResult = basongDAO.basongInsert(basongDTO);
        if(basongResult == 0) {
            basongDAO.basongDelete(orderNum);
            detailDAO.orderDetailDelete(orderNum); 
            orderDAO.orderDelete(orderNum);                                         //���н� order���̺� ����
                                             //���н� detail���̺� ����
            throw new SQLException("��� ���� �Է��� �߸��ƽ��ϴ�.");
        }
        
        //�ֹ��� ��ǰ ���� ����
        productDAO.productUpdateForQuantity(proNum, amount);
        
        return basongResult;
    }

    /**
     * ��ٱ��Ͽ��� �ֹ�
     * UserId�� �޾� ��ٱ��� ��ȸ - > �ֹ� ���̺� ���� - > ������ ��ȸ - > �ݺ������� �����ϰ� ��� ���̺� ����
     */
    @Override
    public int orderInsertByBasket(String userId, String comment, BasongDTO basongDTO) throws SQLException {
        //��ٱ��� ����Ʈ �������̵�� �ҷ�����.
        List<BasketDTO> list = basketDAO.basketSelectByUserId(userId);
        if(list == null) {
            throw new SQLException("��ٱ��ϰ� �������� �ʽ��ϴ�.");
        }
        
        //�ֹ� ���̺� �����ϱ�
        int orderResult = orderDAO.orderInsert(new OrderDTO(userId, comment));
        if(orderResult == 0) {
            throw new SQLException("�ֹ��� �����߽��ϴ�.");
        }
        
        int orderNum = orderDAO.orderSeqSearch();   //�������� ��������
        
        int totalPrice = 0;                         //�� �����ݾ�
        //�ݺ������� ��ٱ��� ��ǰ ������ ����
        for(int i = 0; i < list.size(); i++) {
            int proNum = list.get(i).getProductNum();           //��ǰ��ȣ
            int price = list.get(i).getBasketPrice();           //����
            int amount = list.get(i).getBasketQuantity();       //�ֹ�����
            String option = list.get(i).getBasketOption();      //�ɼ�
            
            //�� ���űݾ� ����
            totalPrice += (price * amount);
            
            //�ֹ��� ��ǰ ���� ����
            productDAO.productUpdateForQuantity(proNum, amount);
            
            //�ֹ��� ���̺� ����
            int deatilResult = detailDAO.orderDetailInsert(new OrderDetailDTO(orderNum, proNum, price, amount, option));
            if(deatilResult == 0) {
                //���� ���� �ݺ����� ���鼭 ���� ������ ���̺��� �ִٸ� ����
                if(detailDAO.orderDetailSelectByOrderNum(orderNum) != null) {       
                    detailDAO.orderDetailDelete(orderNum);
                }
                orderDAO.orderDelete(orderNum);
                throw new SQLException("�ֹ� �������� �߸��Ǿ����ϴ�.");
            }
        }
        
        //��� ���̺� ����
        basongDTO.setOrderNum(orderNum);
        int basongResult = basongDAO.basongInsert(basongDTO);
        if(basongResult == 0) {
            detailDAO.orderDetailDelete(orderNum);
            orderDAO.orderDelete(orderNum);
            throw new SQLException("��������� �߸��Ǿ����ϴ�.");
        } 
        
        //�ֹ� �� ���� ������Ʈ
        int priceUpdate = orderDAO.orderUpdate(orderNum, totalPrice);
        
        //��ٱ��� ���� ����
        int basketResult = basketDAO.basketDelete(userId);
        if(basketResult == 0) {
            throw new SQLException("��ٱ��ϰ� ������� �ʾҽ��ϴ�. Ȯ�����ּ���.");
        }
        
        return basongResult;
    }
    
    /**
     * �ֹ����� ����
     */
    @Override
    public int orderUpdate(OrderDTO dto) throws SQLException {
        return 0;
    }

    /**
     * �ֹ���� ����
     */
    @Override
    public int orderDelete(int orderNum) throws SQLException {
        int result = 0;
        
        //������̺� ����
        int basongResult = basongDAO.basongDelete(orderNum);
        if(basongResult == 0) {
            throw new SQLException("������̺� ������ �Ұ����մϴ�.");
        }
        
        //������ ���̺� ����
        int detailResult = detailDAO.orderDetailDelete(orderNum);
        if(detailResult == 0){
            throw new SQLException("�ֹ��� ���̺� ������ �Ұ����մϴ�.");
        }
        
        //�ֹ����̺� ����
        int orderResult = orderDAO.orderDelete(orderNum);
        if(orderResult == 0) {
            throw new SQLException("�ֹ� ������ �Ұ����մϴ�.");
        }
        
        return basongResult;
    }

}
