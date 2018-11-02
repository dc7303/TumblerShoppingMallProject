package edu.shoppingMall.dto;


/**
 * 주문 DTO입니다.
 * @author mark
 *
 */
public class OrderDTO {
    private int orderNum;           //주문번호
    private int orderProductNum;    //상품번호
    private int orderQuantity;      //상품수량
    private String orderOption;     //주문옵션
    
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
