package edu.shoppingMall.dto;

/**
 * Q&A 게시판 DTO입니다.
 * qnaBoardChildNum 변수는 qnaBoardNum을 참조하여 어느게시글의 답글인지 여부를 증명합니다.
 * @author mark
 *
 */
public class QnABoardDTO {
    private int qnaBoardQno;           //게시판번호
    private String qnaBoardSubject;    //제목
    private String qnaBoardContent;    //내용
    private String qnaBoardPwd;           //비밀번호
    private String qnaBoardDate;       //등록일자
    private String qnaBoardUserId;     //유저아이디
    private int qnaBoardChildNum;      //답글여부
    
   

    
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
