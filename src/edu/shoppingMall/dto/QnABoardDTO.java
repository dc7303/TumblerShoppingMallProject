package edu.shoppingMall.dto;

/**
 * Q&A �Խ��� DTO�Դϴ�.
 * qnaBoardChildNum ������ qnaBoardNum�� �����Ͽ� ����Խñ��� ������� ���θ� �����մϴ�.
 * @author mark
 *
 */
public class QnABoardDTO {
    private int qnaBoardNum;           //�Խ��ǹ�ȣ
    private String qnaBoardSubject;    //����
    private String qnaBoardContent;    //����
    private int qnaBoardPwd;           //��й�ȣ
    private String qnaBoardDate;       //�������
    private String qnaBoardPicture;    //����
    private int qnaBoardUserAdminFlag; //����_������üũ
    private String qnaBoardUserId;     //�������̵�
    private int qnaBoardChildNum;      //��ۿ���
    
    public QnABoardDTO() {}

    public QnABoardDTO(int qnaBoardNum, String qnaBoardSubject, String qnaBoardContent, int qnaBoardPwd,
            String qnaBoardDate, String qnaBoardPicture, int qnaBoardUserAdminFlag, String qnaBoardUserId,
            int qnaBoardChildNum) {
        super();
        this.qnaBoardNum = qnaBoardNum;
        this.qnaBoardSubject = qnaBoardSubject;
        this.qnaBoardContent = qnaBoardContent;
        this.qnaBoardPwd = qnaBoardPwd;
        this.qnaBoardDate = qnaBoardDate;
        this.qnaBoardPicture = qnaBoardPicture;
        this.qnaBoardUserAdminFlag = qnaBoardUserAdminFlag;
        this.qnaBoardUserId = qnaBoardUserId;
        this.qnaBoardChildNum = qnaBoardChildNum;
    }

    public int getQnaBoardNum() {
        return qnaBoardNum;
    }

    public String getQnaBoardSubject() {
        return qnaBoardSubject;
    }

    public String getQnaBoardContent() {
        return qnaBoardContent;
    }

    public int getQnaBoardPwd() {
        return qnaBoardPwd;
    }

    public String getQnaBoardDate() {
        return qnaBoardDate;
    }

    public String getQnaBoardPicture() {
        return qnaBoardPicture;
    }

    public int getQnaBoardUserAdminFlag() {
        return qnaBoardUserAdminFlag;
    }

    public String getQnaBoardUserId() {
        return qnaBoardUserId;
    }

    public int getQnaBoardChildNum() {
        return qnaBoardChildNum;
    }

    public void setQnaBoardNum(int qnaBoardNum) {
        this.qnaBoardNum = qnaBoardNum;
    }

    public void setQnaBoardSubject(String qnaBoardSubject) {
        this.qnaBoardSubject = qnaBoardSubject;
    }

    public void setQnaBoardContent(String qnaBoardContent) {
        this.qnaBoardContent = qnaBoardContent;
    }

    public void setQnaBoardPwd(int qnaBoardPwd) {
        this.qnaBoardPwd = qnaBoardPwd;
    }

    public void setQnaBoardDate(String qnaBoardDate) {
        this.qnaBoardDate = qnaBoardDate;
    }

    public void setQnaBoardPicture(String qnaBoardPicture) {
        this.qnaBoardPicture = qnaBoardPicture;
    }

    public void setQnaBoardUserAdminFlag(int qnaBoardUserAdminFlag) {
        this.qnaBoardUserAdminFlag = qnaBoardUserAdminFlag;
    }

    public void setQnaBoardUserId(String qnaBoardUserId) {
        this.qnaBoardUserId = qnaBoardUserId;
    }

    public void setQnaBoardChildNum(int qnaBoardChildNum) {
        this.qnaBoardChildNum = qnaBoardChildNum;
    }

    
   
    
    
}
