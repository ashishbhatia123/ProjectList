package com.cg.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="coupon")
public class Coupon
{	
	@Id
	@Column(name="couponId",length=10)
	private String couponId;
	@Column(name="couponCode",length=6)
	private String couponCode;
	@Column(name="description",length=50)
	private String description;
	@Column(name="expiryDate",length=50)
	@Temporal(TemporalType.DATE)
	private Date expiryDate;
	@Column(name="couponApplied",length=5)
	private boolean couponApplied;
	
	@ManyToMany
	@JoinTable(name="productCoupon"
					,joinColumns=@JoinColumn(name="prodId")
					,inverseJoinColumns=@JoinColumn(name="couponId")
			   )
	private List<Product> prodCoupon;
	
	public Coupon() 
	{
		super();
	}

	public Coupon(String couponId, String couponCode, String description, Date expiryDate, boolean couponApplied,
			List<Product> prodCoupon) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.description = description;
		this.expiryDate = expiryDate;
		this.couponApplied = couponApplied;
		this.prodCoupon = prodCoupon;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean isCouponApplied() {
		return couponApplied;
	}

	public void setCouponApplied(boolean couponApplied) {
		this.couponApplied = couponApplied;
	}

	public List<Product> getProdCoupon() {
		return prodCoupon;
	}

	public void setProdCoupon(List<Product> prodCoupon) {
		this.prodCoupon = prodCoupon;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", description=" + description
				+ ", expiryDate=" + expiryDate + ", couponApplied=" + couponApplied + ", prodCoupon=" + prodCoupon
				+ "]";
	}

}