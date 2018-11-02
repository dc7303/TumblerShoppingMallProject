package edu.shoppingMall.dto;


/**
 * ���� ���� ���� DTO
 * userOrAdmin ������ ���� ���������� ��������� �Ǵ��մϴ�.
 * @author mark
 *
 */
public class UserInfoDTO {
    private String userId;          //���� ���̵�
    private String userPwd;         //���� ��й�ȣ
    private String userName;        //�̸�
    private String userBirth;       //������� ex(910507)
    private String userAddr;        //�ּ�
    private String userEmail;       //�̸���
    private String userOrAdmin;     //�����ڿ� ���� �Ǵ� ����
     
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
