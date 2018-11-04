package edu.shoppingMall.dto;


/**
 * �ֹ� DTO�Դϴ�.
 * @author mark
 *
 */
public class OrderDTO {
    private int orderNum;           //�ֹ���ȣ
    private int orderProductNum;    //��ǰ��ȣ
    private String orderUserId;     //�������̵�
    private int basongNum;          //��۹�ȣ
    private int orderQuantity;      //��ǰ����
    private String orderOption;     //�ֹ��ɼ�
    private String basongAddr;      //����ּ�
    private String basongPhone;     //�����ȭ��ȣ
    private String coment;          //��Ÿ �䱸����
    private String payment;         //��������
    
    public OrderDTO() {}

    public OrderDTO(int orderNum, int orderProductNum, String orderUserId, int basongNum, int orderQuantity,
            String orderOption, String basongAddr, String basongPhone, String coment, String payment) {
        super();
        this.orderNum = orderNum;
        this.orderProductNum = orderProductNum;
        this.orderUserId = orderUserId;
        this.basongNum = basongNum;
        this.orderQuantity = orderQuantity;
        this.orderOption = orderOption;
        this.basongAddr = basongAddr;
        this.basongPhone = basongPhone;
        this.coment = coment;
        this.payment = payment;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public int getOrderProductNum() {
        return orderProductNum;
    }

    public String getOrderUserId() {
        return orderUserId;
    }

    public int getBasongNum() {
        return basongNum;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public String getOrderOption() {
        return orderOption;
    }

    public String getBasongAddr() {
        return basongAddr;
    }

    public String getBasongPhone() {
        return basongPhone;
    }

    public String getComent() {
        return coment;
    }

    public String getPayment() {
        return payment;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setOrderProductNum(int orderProductNum) {
        this.orderProductNum = orderProductNum;
    }

    public void setOrderUserId(String orderUserId) {
        this.orderUserId = orderUserId;
    }

    public void setBasongNum(int basongNum) {
        this.basongNum = basongNum;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setOrderOption(String orderOption) {
        this.orderOption = orderOption;
    }

    public void setBasongAddr(String basongAddr) {
        this.basongAddr = basongAddr;
    }

    public void setBasongPhone(String basongPhone) {
        this.basongPhone = basongPhone;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    
    
    
}
