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
    private String qnaBoardPhoto;      // ����
    private int qnaBoardChildNum;      //��ۿ���
    
   

    public QnABoardDTO(int qnaBoardQno, String qnaBoardSubject, String qnaBoardContent, String qnaBoardPwd,
			String qnaBoardDate, String qnaBoardUserId, String qnaBoardPhoto, int qnaBoardChildNum) {
		super();
		this.qnaBoardQno = qnaBoardQno;
		this.qnaBoardSubject = qnaBoardSubject;
		this.qnaBoardContent = qnaBoardContent;
		this.qnaBoardPwd = qnaBoardPwd;
		this.qnaBoardDate = qnaBoardDate;
		this.qnaBoardUserId = qnaBoardUserId;
		this.qnaBoardPhoto = qnaBoardPhoto;
		this.qnaBoardChildNum = qnaBoardChildNum;
	}

	public QnABoardDTO(QnABoardDTO dto) {
	}

	public QnABoardDTO(String qnaBoardSubject, String qnaBoardContent,String qnaBoardPwd,String qnaBoardUserId, String qnaBoardPhoto) {
		this(0,qnaBoardSubject,qnaBoardContent,qnaBoardPwd,null,qnaBoardUserId,qnaBoardPhoto,0);
	}
	
	public QnABoardDTO(int qnaBoardQno, String qnaBoardSubject, String qnaBoardContent) {
		this(qnaBoardQno,qnaBoardSubject,qnaBoardContent,null,null,null,null,0);
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

	public String getQnaBoardPhoto() {
		return qnaBoardPhoto;
	}

	public void setQnaBoardPhoto(String qnaBoardPhoto) {
		this.qnaBoardPhoto = qnaBoardPhoto;
	}
    
   
    
    
}
