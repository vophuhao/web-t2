package vn.iostart.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Users implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userid;
	private String email;
	private String userName;
	private String fullName;
	private String passWord;
	private UserRoles roles;
	private String code;
	private int status;
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	private int roleid;
	private String phone;
	
	public Users(String email, String userName, String fullName, String passWord, int roleid, int status, String code) {
		super();
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.passWord = passWord;
		this.code = code;
		this.status = status;
		this.roleid = roleid;
	}
	
	public Users(String email, String userName, String fullName, String code) {
		super();
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.code = code;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public UserRoles getRoles() {
		return roles;
	}
	public void setRoles(UserRoles roles) {
		this.roles = roles;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
