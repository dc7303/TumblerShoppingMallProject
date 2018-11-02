package edu.shoppingMall.dto;


/**
 * ��ǰ DTO�Դϴ�.
 * @author mark
 *
 */
public class ProductDTO {
    private int productNum;             //��ǰ��ȣ
    private String productName;         //�̸�
    private String productInfo;         //����
    private int productPrice;           //����
    private String productCategory;     //ī�װ�
    private String productBrand;        //�귣��
    
    public ProductDTO() {}
    
    public ProductDTO(int productNum, String productName, String productInfo, int productPrice, String productCategory,
            String productBrand) {
        super();
        this.productNum = productNum;               //��ǰ��ȣ
        this.productName = productName;             //��ǰ�̸�
        this.productInfo = productInfo;             //��ǰ����
        this.productPrice = productPrice;           //��ǰ����
        this.productCategory = productCategory;     //ī�װ�
        this.productBrand = productBrand;           //�귣��
    }

    public int getProductNum() {
        return productNum;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
    
    
}
