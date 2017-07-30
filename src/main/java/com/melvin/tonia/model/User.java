package com.melvin.tonia.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="USER_DETAILS")
public class User {
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int userid;
	@Column(name="USER_NAME")
	private String UserName;
	private Date joinedDate;
	@Lob
	private String description;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="city", column=@Column(name="Home_city_name")),
		@AttributeOverride(name="state", column=@Column(name="Home_state_name")),
		@AttributeOverride(name="pincode", column=@Column(name="Home_pincode")),
		
	})
	private Address homeAddress;
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	private Address officeAddress;

	

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	
}
