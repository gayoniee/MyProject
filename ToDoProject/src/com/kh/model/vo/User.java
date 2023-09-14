package com.kh.model.vo;

import java.sql.Date;

public class User {

	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private int age;
	private String gender;
	private String email;
	private String phone;
	private Date enrollDate;
	
	public User() {
		super();
	}
	
	
	
	public User(int userNo, String userId, String userPw, String userName, int age, String gender, String email,
			String phone, Date enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.enrollDate = enrollDate;
	}



	public User(String userId, String userPw, String userName, int age, String gender, String email, String phone) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return userNo + ", " + userId + ", " + userPw + ", " + userName
				+ ", " + age + ", " + gender + ", " + email + ", " + phone + ", "
				+ enrollDate;
	}
	
	
	
	
	
}
