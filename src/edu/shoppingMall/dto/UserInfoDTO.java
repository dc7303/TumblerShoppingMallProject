package edu.shoppingMall.dto;


/**
 * 유저 정보 관련 DTO
 * userOrAdmin 변수를 통해 관리자인지 사용자인지 판단합니다.
 * @author mark
 *
 */
public class UserInfoDTO {
    private String userId;          //유저 아이디
    private String userName;        //이름
    private String userPwd;         //유저 비밀번호
    private String userBirth;       //생년월일 ex(910507)
    private String userPhone;       //핸드폰번호
    private String userAddr;        //주소
    private String userEmail;       //이메일
    private int userAdminFlag;        //관리자와 유저 판단 변수
    private int userSignUpFlag;           //회원탈퇴여부
    private String userDate;        //가입일자
     
    public UserInfoDTO() {}


    public UserInfoDTO(String userId, String userName, String userPwd, String userBirth, String userPhone,
            String userAddr, String userEmail, int userAdminFlag, int userSignUpFlag, String userDate) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userBirth = userBirth;
        this.userPhone = userPhone;
        this.userAddr = userAddr;
        this.userEmail = userEmail;
        this.userAdminFlag = userAdminFlag;
        this.userSignUpFlag = userSignUpFlag;
        this.userDate = userDate;
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

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getUserAdminFlag() {
        return userAdminFlag;
    }

    public int getUserSignUpFlag() {
        return userSignUpFlag;
    }

    public String getUserDate() {
        return userDate;
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

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserAdminFlag(int userAdminFlag) {
        this.userAdminFlag = userAdminFlag;
    }

    public void setUserSignUpFlag(int userSignUpFlag) {
        this.userSignUpFlag = userSignUpFlag;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    
}
