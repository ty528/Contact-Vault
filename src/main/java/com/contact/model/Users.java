package com.contact.model;

import jakarta.persistence.Entity;
import java.util.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Users
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	
	private String userName;
	
	private String password;
	
	private String mobileNo;
	
	private  String email;
	
	
	
	public Users()
	{
		
	}

	public Long getUserId() {
		return userid;
	}

	public void setUserId(Long userId) {
		this.userid = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userid + ", userName=" + userName + ", password=" + password + ", mobileNo="
				+ mobileNo + ", email=" + email + "]";
	}

	public Users(Long userId, String userName, String password, String mobileNo, String email) {
		super();
		this.userid = userId;
		this.userName = userName;
		this.password = password;
		this.mobileNo = mobileNo;
		this.email = email;
	}
	
	
	
}
