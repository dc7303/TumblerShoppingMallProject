package edu.shoppingMall.dto;


/**
 * �������� �Խ��� DTO�Դϴ�.
 * @author mark
 *
 */
public class NoticeBoardDTO {
    
    private int noticeBoardNum;         //�Խ��ǹ�ȣ
    private String noticeBoardSubject;  //����
    private String noticeBoardContent;  //����
    private String date;                //�����
    public NoticeBoardDTO() {}

    public NoticeBoardDTO(int noticeBoardNum, String noticeBoardSubject, String noticeBoardContent) {
		super();
		this.noticeBoardNum = noticeBoardNum;
		this.noticeBoardSubject = noticeBoardSubject;
		this.noticeBoardContent = noticeBoardContent;
	}

    

    public NoticeBoardDTO(int noticeBoardNum, String noticeBoardSubject, String noticeBoardContent, String date) {
        super();
        this.noticeBoardNum = noticeBoardNum;
        this.noticeBoardSubject = noticeBoardSubject;
        this.noticeBoardContent = noticeBoardContent;
        this.date = date;
    }

    public int getNoticeBoardNum() {
        return noticeBoardNum;
    }

    public String getNoticeBoardSubject() {
        return noticeBoardSubject;
    }

    public String getNoticeBoardContent() {
        return noticeBoardContent;
    }

    public String getDate() {
        return date;
    }

    public void setNoticeBoardNum(int noticeBoardNum) {
        this.noticeBoardNum = noticeBoardNum;
    }

    public void setNoticeBoardSubject(String noticeBoardSubject) {
        this.noticeBoardSubject = noticeBoardSubject;
    }

    public void setNoticeBoardContent(String noticeBoardContent) {
        this.noticeBoardContent = noticeBoardContent;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
