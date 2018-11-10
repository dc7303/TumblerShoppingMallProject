package edu.shoppingMall.dto;

/**
 * Q&A �Խ��� DTO�Դϴ�.
 * qnaBoardChildNum ������ qnaBoardNum�� �����Ͽ� ����Խñ��� ������� ���θ� �����մϴ�.
 * @author mark
 *
 */
public class QnABoardDTO {
    private int qnaBoardQno;           //�Խ��ǹ�ȣ
    private String qnaBoardSubject;    //����
    private String qnaBoardContent;    //����
    private String qnaBoardPwd;           //��й�ȣ
    private String qnaBoardDate;       //�������
    private String qnaBoardUserId;     //�������̵�
    private int qnaBoardChildNum;      //��ۿ���
    
   

    
    public QnABoardDTO(int qnaBoardQno, String qnaBoardSubject, String qnaBoardContent,  String qnaBoardPwd,
    		String qnaBoardDate, String qnaBoardUserId, int qnaBoardChildNum) {
        super();
        this.qnaBoardQno = qnaBoardQno;
        this.qnaBoardSubject = qnaBoardSubject;
        this.qnaBoardContent = qnaBoardContent;
        this.qnaBoardDate = qnaBoardDate;
        this.qnaBoardPwd = qnaBoardPwd;
        this.qnaBoardUserId = qnaBoardUserId;
        this.qnaBoardChildNum = qnaBoardChildNum;
    }

    public QnABoardDTO(QnABoardDTO dto) {
	}

	

	public QnABoardDTO(int no, String subject, String content) {
		this(no,subject,content,null,null,null,0);
	}

	public int getQnaBoardQno() {
        return qnaBoardQno;
    }

    public String getQnaBoardSubject() {
        return qnaBoardSubject;
    }

    public String getQnaBoardContent() {
        return qnaBoardContent;
    }

    public String getQnaBoardDate() {
        return qnaBoardDate;
    }

    public String getQnaBoardPwd() {
        return qnaBoardPwd;
    }

    public String getQnaBoardUserId() {
        return qnaBoardUserId;
    }

    public int getQnaBoardChildNum() {
        return qnaBoardChildNum;
    }

    public void setQnaBoardQno(int qnaBoardQno) {
        this.qnaBoardQno = qnaBoardQno;
    }

    public void setQnaBoardSubject(String qnaBoardSubject) {
        this.qnaBoardSubject = qnaBoardSubject;
    }

    public void setQnaBoardContent(String qnaBoardContent) {
        this.qnaBoardContent = qnaBoardContent;
    }

    public void setQnaBoardDate(String qnaBoardDate) {
        this.qnaBoardDate = qnaBoardDate;
    }

    public void setQnaBoardPwd(String qnaBoardPwd) {
        this.qnaBoardPwd = qnaBoardPwd;
    }

    public void setQnaBoardUserId(String qnaBoardUserId) {
        this.qnaBoardUserId = qnaBoardUserId;
    }

    public void setQnaBoardChildNum(int qnaBoardChildNum) {
        this.qnaBoardChildNum = qnaBoardChildNum;
    }
    
   
    
    
}
