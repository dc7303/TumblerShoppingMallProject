package edu.shoppingMall.dto;


/**
 * 유저 정보 관련 DTO
 * userOrAdmin 변수를 통해 관리자인지 사용자인지 판단합니다.
 * @author mark
 *
 */
public class UserInfoDTO {
    private String userId;          //유저 아이디
    private String userPwd;         //유저 비밀번호
    private String userName;        //이름
    private String userBirth;       //생년월일 ex(910507)
    private String userAddr;        //주소
    private String userEmail;       //이메일
    private String userOrAdmin;     //관리자와 유저 판단 변수
     
    public UserInfoDTO() {}
    
    public UserInfoDTO(String userId, String userPwd, String userName, String userBirth, String userAddr,
            String userEmail, String userOrAdmin) {
        super();
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userBirth = userBirth;
        this.userAddr = userAddr;
        this.userEmail = userEmail;
        this.userOrAdmin = userOrAdmin;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserOrAdmin() {
        return userOrAdmin;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserOrAdmin(String userOrAdmin) {
        this.userOrAdmin = userOrAdmin;
    }
    
    
}
