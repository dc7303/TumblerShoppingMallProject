package edu.shoppingMall.dto;

public class OrderDetailDTO {
    private int orderDetailNum;             //주문상세번호
    private int orderNum;                   //주문번호
    private int productNum;                 //상품번호
    private int orderDetailPrice;           //주문가격
    private int orderDetailQuantity;        //수량
    private int orderDetailOption;          //옵션
    private String orderDetailDate;         //주문일자
    public OrderDetailDTO(int orderDetailNum, int orderNum, int productNum, int orderDetailPrice,
            int orderDetailQuantity, int orderDetailOption, String orderDetailDate) {
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
    public int getOrderDetailOption() {
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
    public void setOrderDetailOption(int orderDetailOption) {
        this.orderDetailOption = orderDetailOption;
    }
    public void setOrderDetailDate(String orderDetailDate) {
        this.orderDetailDate = orderDetailDate;
    }
    
    
    
}
