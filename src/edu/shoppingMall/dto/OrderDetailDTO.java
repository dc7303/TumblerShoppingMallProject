package edu.shoppingMall.dto;

public class OrderDetailDTO {
    private int orderDetailNum;             //�ֹ��󼼹�ȣ
    private int orderNum;                   //�ֹ���ȣ
    private int productNum;                 //��ǰ��ȣ
    private int orderDetailPrice;           //�ֹ�����
    private int orderDetailQuantity;        //����
    private String orderDetailOption;       //�ɼ�
    private String orderDetailDate;         //�ֹ�����
    
    
    public OrderDetailDTO() {}
    
    
    
    public OrderDetailDTO(int productNum, int orderDetailQuantity, String orderDetailOption) {
        super();
        this.productNum = productNum;
        this.orderDetailQuantity = orderDetailQuantity;
        this.orderDetailOption = orderDetailOption;
    }

    

    public OrderDetailDTO(int orderNum, int productNum, int orderDetailPrice, int orderDetailQuantity,
            String orderDetailOption) {
        super();
        this.orderNum = orderNum;
        this.productNum = productNum;
        this.orderDetailPrice = orderDetailPrice;
        this.orderDetailQuantity = orderDetailQuantity;
        this.orderDetailOption = orderDetailOption;
    }



    public OrderDetailDTO(int orderDetailNum, int orderNum, int productNum, int orderDetailPrice,
            int orderDetailQuantity, String orderDetailOption, String orderDetailDate) {
        super();
        this.orderDetailNum = orderDetailNum;
        this.orderNum = orderNum;
        this.productNum = productNum;
        this.orderDetailPrice = orderDetailPrice;
        this.orderDetailQuantity = orderDetailQuantity;
        this.orderDetailOption = orderDetailOption;
        this.orderDetailDate = orderDetailDate;
    }
    
    
    public int getOrderDetailNum() {
        return orderDetailNum;
    }
    public int getOrderNum() {
        return orderNum;
    }
    public int getProductNum() {
        return productNum;
    }
    public int getOrderDetailPrice() {
        return orderDetailPrice;
    }
    public int getOrderDetailQuantity() {
        return orderDetailQuantity;
    }
    public String getOrderDetailOption() {
        return orderDetailOption;
    }
    public String getOrderDetailDate() {
        return orderDetailDate;
    }
    public void setOrderDetailNum(int orderDetailNum) {
        this.orderDetailNum = orderDetailNum;
    }
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
    public void setOrderDetailPrice(int orderDetailPrice) {
        this.orderDetailPrice = orderDetailPrice;
    }
    public void setOrderDetailQuantity(int orderDetailQuantity) {
        this.orderDetailQuantity = orderDetailQuantity;
    }
    public void setOrderDetailOption(String orderDetailOption) {
        this.orderDetailOption = orderDetailOption;
    }
    public void setOrderDetailDate(String orderDetailDate) {
        this.orderDetailDate = orderDetailDate;
    }
    
    
    
}
