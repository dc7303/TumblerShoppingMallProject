package edu.shoppingMall.dto;


/**
 * �ֹ� DTO�Դϴ�.
 * @author mark
 *
 */
public class OrderDTO {
    private int orderNum;           //�ֹ���ȣ
    private int orderProductNum;    //��ǰ��ȣ
    private int orderQuantity;      //��ǰ����
    private String orderOption;     //�ֹ��ɼ�
    
    public OrderDTO() {}
    
    public OrderDTO(int orderNum, int orderProductNum, int orderQuantity, String orderOption) {
        super();
        this.orderNum = orderNum;
        this.orderProductNum = orderProductNum;
        this.orderQuantity = orderQuantity;
        this.orderOption = orderOption;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public int getOrderProductNum() {
        return orderProductNum;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public String getOrderOption() {
        return orderOption;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setOrderProductNum(int orderProductNum) {
        this.orderProductNum = orderProductNum;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setOrderOption(String orderOption) {
        this.orderOption = orderOption;
    }
    
    
}
