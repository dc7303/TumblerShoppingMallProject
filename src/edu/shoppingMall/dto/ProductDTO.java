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
    private String productFicture;      //���� ���ϸ�
    private String productBrand;        //�귣��
    
    public ProductDTO() {}

    public ProductDTO(int productNum, String productName, String productInfo, int productPrice, String productCategory,
            String productFicture, String productBrand) {
        super();
        this.productNum = productNum;
        this.productName = productName;
        this.productInfo = productInfo;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productFicture = productFicture;
        this.productBrand = productBrand;
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

    public String getProductFicture() {
        return productFicture;
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

    public void setProductFicture(String productFicture) {
        this.productFicture = productFicture;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
    
   
    
}
