package com.cg.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="merchant")
public class Merchant 
{
	@Id
	@Column(name="merchantMobileNo")
	private String merchantMobileNo;
	@Column(name="merchantName",length=50)
	private String merchantName;
	@Column(name="email",length=70)
	private String email;
	@Column(name="password",length=20)
	private String password;
	@Column(name="merchantType",length=50)
	private String merchantType;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="merchantAddress")
	private List<Address> addresses=new ArrayList<>();
	
	@ManyToMany(mappedBy="merchantFeedback")
//	@JoinTable(name="merchant_feedback"
//			,joinColumns=@JoinColumn(name="feedback_id")
//			,inverseJoinColumns= 
//			{
//					@JoinColumn(name="merchant_id",referencedColumnName="merchant_mobile_no")
//					,@JoinColumn(name="customer_id",referencedColumnName="customer_mobile_no")
//			}
//			)
	private List<Feedback> feedback=new ArrayList<>();
	
	@ManyToMany(mappedBy="merchantResponse")
//	@JoinTable(name="merchant_response"
//			,joinColumns=@JoinColumn(name="response_id")
//			,inverseJoinColumns= 
//			{
//					@JoinColumn(name="merchant_id",referencedColumnName="merchant_mobile_no")
//					,@JoinColumn(name="customer_id",referencedColumnName="customer_mobile_no")
//			}
//			)
	private List<Response> response=new ArrayList<>();
	
	@ManyToMany(mappedBy="merchantProduct")
//	@JoinTable(name="merchant_product"
//					,joinColumns=@JoinColumn(name="merchant_id")
//					,inverseJoinColumns= {@JoinColumn(name="prod_id")}
//			  )
	private List<Product> products = new ArrayList<>();
 	
	public Merchant() 
	{
		super();
	}

	public Merchant(String merchantMobileNo, String merchantName, String email, String password,
			String merchantType, List<Address> addresses, List<Feedback> feedback, List<Response> response,
			List<Product> products) {
		super();
		this.merchantMobileNo = merchantMobileNo;
		this.merchantName = merchantName;
		this.email = email;
		this.password = password;
		this.merchantType = merchantType;
		this.addresses = addresses;
		this.feedback = feedback;
		this.response = response;
		this.products = products;
	}

	public String getMerchantMobileNo() {
		return merchantMobileNo;
	}

	public void setMerchantMobileNo(String merchantMobileNo) {
		this.merchantMobileNo = merchantMobileNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	public List<Response> getResponse() {
		return response;
	}

	public void setResponse(List<Response> response) {
		this.response = response;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Merchant [merchantMobileNo=" + merchantMobileNo + ", merchantName=" + merchantName + ", email=" + email
				+ ", password=" + password + ", merchantType=" + merchantType + ", addresses=" + addresses
				+ ", feedback=" + feedback + ", response=" + response + ", products=" + products + "]";
	}

	
}
