package edu.shoppingMall.dto;

/**
 * Q&A 게시판 DTO입니다.
 * qnaBoardChildNum 변수는 qnaBoardNum을 참조하여 어느게시글의 답글인지 여부를 증명합니다.
 * @author mark
 *
 */
public class QnABoardDTO {
    private int qnaBoardNum;           //게시판번호
    private String qnaBoardSubject;    //제목
    private String qnaBoardContent;    //내용
    private String qnaBoardDate;       //등록일자
    private int qnaBoardPwd;           //비밀번호
    private String qnaBoardUserId;     //유저아이디
    private int qnaBoardChildNum;      //답글여부
    
    public QnABoardDTO() {}

    public QnABoardDTO(int qnaBoardNum, String qnaBoardSubject, String qnaBoardContent, String qnaBoardDate,
            int qnaBoardPwd, String qnaBoardUserId, int qnaBoardChildNum) {
        super();
        this.qnaBoardNum = qnaBoardNum;
        this.qnaBoardSubject = qnaBoardSubject;
        this.qnaBoardContent = qnaBoardContent;
        this.qnaBoardDate = qnaBoardDate;
        this.qnaBoardPwd = qnaBoardPwd;
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

    public String getQnaBoardDate() {
        return qnaBoardDate;
    }

    public int getQnaBoardPwd() {
        return qnaBoardPwd;
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

    public void setQnaBoardDate(String qnaBoardDate) {
        this.qnaBoardDate = qnaBoardDate;
    }

    public void setQnaBoardPwd(int qnaBoardPwd) {
        this.qnaBoardPwd = qnaBoardPwd;
    }

    public void setQnaBoardUserId(String qnaBoardUserId) {
        this.qnaBoardUserId = qnaBoardUserId;
    }

    public void setQnaBoardChildNum(int qnaBoardChildNum) {
        this.qnaBoardChildNum = qnaBoardChildNum;
    }
    
   
    
    
}
