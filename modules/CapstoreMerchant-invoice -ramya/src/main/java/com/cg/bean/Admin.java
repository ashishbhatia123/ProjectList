package com.cg.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="capstoreAdmin")
public class Admin
{
	@Id
	@Column(name="mobileNo",length=10)
	private String mobileNo;
	@Column(name="name",length=50)
	private String name;
	@Column(name="password",length=20)
	private String password;
	@Column(name="email",length=70)
	private String email;
	
	
	public Admin()
	{
		super();
	}

	public Admin(String mobileNo, String name, String email, String password) 
	{
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [mobileNo=" + mobileNo + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}

}