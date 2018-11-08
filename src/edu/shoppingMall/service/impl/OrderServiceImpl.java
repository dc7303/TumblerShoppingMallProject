package edu.shoppingMall.service.impl;

import java.sql.SQLException;
import java.util.List;

import edu.shoppingMall.dao.BasongDAO;
import edu.shoppingMall.dao.OrderDAO;
import edu.shoppingMall.dao.OrderDetailDAO;
import edu.shoppingMall.dao.impl.BasongDAOImpl;
import edu.shoppingMall.dao.impl.OrderDAOImpl;
import edu.shoppingMall.dao.impl.OrderDetailDAOImpl;
import edu.shoppingMall.dto.OrderDTO;
import edu.shoppingMall.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private static OrderServiceImpl service = new OrderServiceImpl();
    private OrderDAO orderDAO = OrderDAOImpl.getInstance();
    private OrderDetailDAO detailDAO = OrderDetailDAOImpl.getInstance();
    private BasongDAO basongDAO = new BasongDAOImpl().getInstance();
    
    public static OrderServiceImpl getInstance() {
        return service;
    }

    /**
     * �ֹ� ��ü �˻� (OrderDetailDTO�� BasongDTO�� ������ DTO�� �����Ѵ�.)
     */
    @Override
    public List<OrderDTO> orderSelectAll() throws SQLException {

        return null;
    }

    /**
     * �ֹ� ��ȸ UserID�� ��ȸ�ϱ� ���ϰ��� (OrderDetailDTO�� BasongDTO�� ������ DTO�� �����Ѵ�.) ID�� �Ķ���ͷ�
     * �޾� �ֹ���, �ֹ� ���� ID�� ��ȸ ������ DAO �޼ҵ带 ����� �� �ִ�.
     */
    @Override
    public List<OrderDTO> orderSelectByUserId(String userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * �ֹ���ȣ�� �˻��ϱ� (OrderDetailDTO�� BasongDTO�� ������ DTO�� �����Ѵ�.) �ֹ���ȣ�� �Ķ���ͷ� �޾� ���,
     * �ֹ���, �ֹ� ���� �ֹ���ȣ�� ��ȸ ������ DAO �޼ҵ带 ����� �� �ִ�.
     */
    @Override
    public OrderDTO orderSelectByOrderNum(int orderNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * �ֹ� ����
     */
    @Override
    public int orderInsert(OrderDTO dto) throws SQLException {

        return 0;
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
        return 0;
    }

}
