package edu.shoppingMall.dto;


/**
 * 주문 DTO입니다.
 * @author mark
 *
 */
public class OrderDTO {
    private int orderNum;            //주문번호
    private String orderUserId;      //유저아이디
    private String orderDate;        //결제일자
    private int orderPrice;          //결제금액
    private String orderComment;     //주문기타사항
    private OrderDetailDTO detailDTO;//상품디테일DTO
    private BasongDTO basongDTO;     //배송 DTO
    public OrderDTO() {}

    
    public OrderDTO(String orderUserId, String orderComment) {
        super();
        this.orderUserId = orderUserId;
        this.orderComment = orderComment;
    }
    
    public OrderDTO(String orderUserId, String orderComment, int orderPrice) {
        super();
        this.orderUserId = orderUserId;
        this.orderComment = orderComment;
        this.orderPrice = orderPrice;
    }
    

    public OrderDTO(String orderUserId, String orderComment, 
            OrderDetailDTO detailDTO, BasongDTO basongDTO) {
        super();
        this.orderUserId = orderUserId;
        this.orderComment = orderComment;
        this.detailDTO = detailDTO;
        this.basongDTO = basongDTO;
    }

    public OrderDTO(int orderNum, String orderUserId, String orderDate, int orderPrice, String orderComment) {
        super();
        this.orderNum = orderNum;
        this.orderUserId = orderUserId;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        this.orderComment = orderComment;
    }
    
    
    public OrderDTO(int orderNum, String orderUserId, String orderDate, int orderPrice, String orderComment,
            OrderDetailDTO detailDTO, BasongDTO basongDTO) {
        super();
        this.orderNum = orderNum;
        this.orderUserId = orderUserId;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        this.orderComment = orderComment;
        this.detailDTO = detailDTO;
        this.basongDTO = basongDTO;
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

    public OrderDetailDTO getDetailDTO() {
        return detailDTO;
    }

    public BasongDTO getBasongDTO() {
        return basongDTO;
    }

    public void setDetailDTO(OrderDetailDTO detailDTO) {
        this.detailDTO = detailDTO;
    }

    public void setBasongDTO(BasongDTO basongDTO) {
        this.basongDTO = basongDTO;
    }

   
    
    
}
