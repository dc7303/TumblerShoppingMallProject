package edu.shoppingMall.dto;

/**
 * @author sorry
 *
 */
public class BasketDTO {
    private int basketNum;              //��ٱ��Ϲ�ȣ
    private int productNum;             //��ǰ��ȣ
    private String userId;              //�������̵�
    private String basketOption;        //�ɼ�
    private int basketQuantity;         //����
    private int basketPrice;            //�Ѱ���
    private ProductDTO productDto; // productDTO
    public BasketDTO(int basketNum, int productNum, String userId, String basketOption, int basketQuantity,
            int basketPrice) {
        super();
        this.basketNum = basketNum;
        this.productNum = productNum;
        this.userId = userId;
        this.basketOption = basketOption;
        this.basketQuantity = basketQuantity;
        this.basketPrice = basketPrice;
    }
    public int getBasketNum() {
        return basketNum;
    }
    public int getProductNum() {
        return productNum;
    }
    public String getUserId() {
        return userId;
    }
    public String getBasketOption() {
        return basketOption;
    }
    public int getBasketQuantity() {
        return basketQuantity;
    }
    public int getBasketPrice() {
        return basketPrice;
    }
    public void setBasketNum(int basketNum) {
        this.basketNum = basketNum;
    }
    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setBasketOption(String basketOption) {
        this.basketOption = basketOption;
    }
    public void setBasketQuantity(int basketQuantity) {
        this.basketQuantity = basketQuantity;
    }
    public void setBasketPrice(int basketPrice) {
        this.basketPrice = basketPrice;
    }
	public ProductDTO getProductDto() {
		return productDto;
	}
	public void setProductDto(ProductDTO productDto) {
		this.productDto = productDto;
	}
    
}
