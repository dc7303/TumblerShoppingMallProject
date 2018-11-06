package edu.shoppingMall.dto;


/**
 * ���� ���� ���� DTO
 * userOrAdmin ������ ���� ���������� ��������� �Ǵ��մϴ�.
 * @author mark
 *
 */
public class UserInfoDTO {
    private String userId;          //���� ���̵�
    private String userName;        //�̸�
    private String userPwd;         //���� ��й�ȣ
    private String userBirth;       //������� ex(910507)
    private String userPhone;       //�ڵ�����ȣ
    private String userAddr;        //�ּ�
    private String userEmail;       //�̸���
    private int userAdminFlag;        //�����ڿ� ���� �Ǵ� ����
    private int userSignUpFlag;           //ȸ��Ż�𿩺�
    private String userDate;        //��������
     
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
