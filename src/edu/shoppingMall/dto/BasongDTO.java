package edu.shoppingMall.dto;

public class BasongDTO {
    private int basongNum;              //��۹�ȣ
    private String basongCompany;       //�ù�ȸ��
    private String basongInvoiceNum;    //�����ȣ
    private String basongAddr;          //����� �ּ�
    private String basongPhone;         //�ֹ��� ��ȣ
    private String basongDate;          //�������
    private String orderNum;            //�ֹ���ȣ
    public BasongDTO(int basongNum, String basongCompany, String basongInvoiceNum, String basongAddr,
            String basongPhone, String basongDate, String orderNum) {
        super();
        this.basongNum = basongNum;
        this.basongCompany = basongCompany;
        this.basongInvoiceNum = basongInvoiceNum;
        this.basongAddr = basongAddr;
        this.basongPhone = basongPhone;
        this.basongDate = basongDate;
        this.orderNum = orderNum;
    }
    public int getBasongNum() {
        return basongNum;
    }
    public String getBasongCompany() {
        return basongCompany;
    }
    public String getBasongInvoiceNum() {
        return basongInvoiceNum;
    }
    public String getBasongAddr() {
        return basongAddr;
    }
    public String getBasongPhone() {
        return basongPhone;
    }
    public String getBasongDate() {
        return basongDate;
    }
    public String getOrderNum() {
        return orderNum;
    }
    public void setBasongNum(int basongNum) {
        this.basongNum = basongNum;
    }
    public void setBasongCompany(String basongCompany) {
        this.basongCompany = basongCompany;
    }
    public void setBasongInvoiceNum(String basongInvoiceNum) {
        this.basongInvoiceNum = basongInvoiceNum;
    }
    public void setBasongAddr(String basongAddr) {
        this.basongAddr = basongAddr;
    }
    public void setBasongPhone(String basongPhone) {
        this.basongPhone = basongPhone;
    }
    public void setBasongDate(String basongDate) {
        this.basongDate = basongDate;
    }
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
    
    
}
