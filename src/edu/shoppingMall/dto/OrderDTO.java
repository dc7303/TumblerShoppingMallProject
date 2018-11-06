package edu.shoppingMall.dto;


/**
 * 주문 DTO입니다.
 * @author mark
 *
 */
public class OrderDTO {
    private int orderNum;           //주문번호
    private String orderUserId;     //유저아이디
    private String orderDate;       //결제일자
    private int orderPrice;         //결제금액
    private String orderComment;    //주문기타사항
    private int basongFlag;         //배송상태
    
    public OrderDTO() {}

    public OrderDTO(int orderNum, String orderUserId, String orderDate, int orderPrice, String orderComment,
            int basongFlag) {
        super();
        this.orderNum = orderNum;
        this.orderUserId = orderUserId;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        this.orderComment = orderComment;
        this.basongFlag = basongFlag;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getOrderUserId() {
        return orderUserId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public int getBasongFlag() {
        return basongFlag;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setOrderUserId(String orderUserId) {
        this.orderUserId = orderUserId;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public void setBasongFlag(int basongFlag) {
        this.basongFlag = basongFlag;
    }

   
    
    
}
