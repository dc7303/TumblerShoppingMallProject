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
    private int productQuantity;        //재고
    private String date;                //등록일자
    
    public ProductDTO() {}

    public ProductDTO(int productNum, String productName, String productInfo, int productPrice, String productCategory,
            String productPicture, String productBrand, int productQuantity, String date) {
        super();
        this.productNum = productNum;
        this.productName = productName;
        this.productInfo = productInfo;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productPicture = productPicture;
        this.productBrand = productBrand;
        this.productQuantity = productQuantity;
        this.date = date;
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

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getDate() {
        return date;
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

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    
}
