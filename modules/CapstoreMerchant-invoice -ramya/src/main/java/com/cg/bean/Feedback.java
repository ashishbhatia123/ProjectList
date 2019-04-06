package com.cg.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback
{
	@Id
	@Column(name="feedbackId",length=10)
	private String feedbackId;
	@Column(name="description")
	private String description;
	@Column(name="rating")
	private double rating;
	
	@ManyToMany
	@JoinTable(name="merchantFeedback"
			,joinColumns=@JoinColumn(name="feedbackId")
			,inverseJoinColumns= {
					@JoinColumn(name="merchantId",referencedColumnName="merchantMobileNo")
					}
			)
	private List<Merchant> merchantFeedback=new ArrayList<>(); 
	@ManyToMany
	@JoinTable(name="merchantFeedback"
			,joinColumns=@JoinColumn(name="feedbackId")
			,inverseJoinColumns= 
			{
					@JoinColumn(name="customerId",referencedColumnName="customerMobileNo")
			})
	private List<Customer> customerFeedback=new ArrayList<>();
	@ManyToMany
	@JoinTable(name="productFeedback"
			,joinColumns=@JoinColumn(name="feedbackId")
			,inverseJoinColumns= @JoinColumn(name="prodId")
			)
	private List<Product> prodFeedback=new ArrayList<>(); 

	public Feedback() 
	{
		super();
	}

	public Feedback(String feedbackId, String description, double rating, List<Merchant> merchantFeedback,
			List<Customer> customerFeedback, List<Product> prodFeedback) {
		super();
		this.feedbackId = feedbackId;
		this.description = description;
		this.rating = rating;
		this.merchantFeedback = merchantFeedback;
		this.customerFeedback = customerFeedback;
		this.prodFeedback = prodFeedback;
	}

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<Merchant> getMerchantFeedback() {
		return merchantFeedback;
	}

	public void setMerchantFeedback(List<Merchant> merchantFeedback) {
		this.merchantFeedback = merchantFeedback;
	}

	public List<Customer> getCustomerFeedback() {
		return customerFeedback;
	}

	public void setCustomerFeedback(List<Customer> customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	public List<Product> getProdFeedback() {
		return prodFeedback;
	}

	public void setProdFeedback(List<Product> prodFeedback) {
		this.prodFeedback = prodFeedback;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", description=" + description + ", rating=" + rating
				+ ", merchantFeedback=" + merchantFeedback + ", customerFeedback=" + customerFeedback
				+ ", prodFeedback=" + prodFeedback + "]";
	}



}
