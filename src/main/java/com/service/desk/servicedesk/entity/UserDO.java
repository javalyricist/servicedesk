package com.service.desk.servicedesk.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserDO {

    @Id
	private String user_ID;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "create_date", nullable = false)
	private Date createDt;
	@Column(name = "update_date", nullable = false)
	private Date updateDt;

	
	public UserDO(String user_ID, String password, Date createDt, Date updateDt) {
		super();
		this.user_ID = user_ID;
		this.password = password;
		this.createDt = createDt;
		this.updateDt = updateDt;
	}

	public UserDO() {
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

}
