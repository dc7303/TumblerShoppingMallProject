package edu.shoppingMall.dto;


/**
 * 제품 DTO입니다.
 * @author mark
 *
 */
public class ProductDTO {
    private int productNum;             //제품번호
    private String productName;         //이름
    private String productInfo;         //정보
    private int productPrice;           //가격
    private String productCategory;     //카테고리
    private String productPicture;      //사진 파일명
    private String productBrand;        //브랜드
    
    public ProductDTO() {}

    public ProductDTO(int productNum, String productName, String productInfo, int productPrice, String productCategory,
            String productFicture, String productBrand) {
        super();
        this.productNum = productNum;
        this.productName = productName;
        this.productInfo = productInfo;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productPicture = productFicture;
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

    public String getProductPicture() {
        return productPicture;
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

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

   
   
    
}
