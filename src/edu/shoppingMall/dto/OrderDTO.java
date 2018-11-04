package edu.shoppingMall.dto;


/**
 * 주문 DTO입니다.
 * @author mark
 *
 */
public class OrderDTO {
    private int orderNum;           //주문번호
    private int orderProductNum;    //상품번호
    private String orderUserId;     //유저아이디
    private int basongNum;          //배송번호
    private int orderQuantity;      //상품수량
    private String orderOption;     //주문옵션
    private String basongAddr;      //배송주소
    private String basongPhone;     //배송전화번호
    private String coment;          //기타 요구사항
    private String payment;         //결제여부
    
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
