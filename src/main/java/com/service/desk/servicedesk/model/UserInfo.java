package com.service.desk.servicedesk.model;

public class UserInfo {

	private String userID;

	private String password;

	public UserInfo(String userID, String password) {
		super();
		this.userID = userID;
		this.password = password;
	}

	public String getUserID() {
		return userID;
	}

	public String getPassword() {
		return password;
	}
}
