package mh.cherry.user.entity;

import java.sql.Timestamp;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userMail;
	private String userGender;
	private String userPwd;
    private int userStatus;
    private String userRealname;
    private Timestamp userLastlogintime;
    //常量
    public static int USER_STATUS_VALID=1;
    public static int USER_STATUS_INVALID=0;
    
	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String userName, String userMail, String userGender,
			String userPwd) {
		this.userName = userName;
		this.userMail = userMail;
		this.userGender = userGender;
		this.userPwd = userPwd;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return this.userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserGender() {
		return this.userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserRealname() {
		return userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}

	public Timestamp getUserLastlogintime() {
		return userLastlogintime;
	}

	public void setUserLastlogintime(Timestamp userLastlogintime) {
		this.userLastlogintime = userLastlogintime;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userMail=" + userMail + ", userGender=" + userGender
				+ ", userPwd=" + userPwd + ", userStatus=" + userStatus
				+ ", userRealname=" + userRealname + ", userLastlogintime="
				+ userLastlogintime + "]";
	}
	
}