package com.cg.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "savedcard")
public class SavedCardDetails 
{
	@Id
	@Column(name="sno")
	private String sno;
	@Column(name="cardHolderName",length=50)
	private String cardHolderName;
	@Column(name="cardno",length=16)
	private String CardNumber;
	@Column(name="expirymonth",length=2)
	private  int expiryMonth;
	@Column(name="expiryYear",length=4)
	private int expiryYear;
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customerCard;
	
	public SavedCardDetails() 
	{
		super();
	}

	public SavedCardDetails(String sno, String cardHolderName, String cardNumber, int expiryMonth, int expiryYear,
			Customer customerCard) {
		super();
		this.sno = sno;
		this.cardHolderName = cardHolderName;
		CardNumber = cardNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.customerCard = customerCard;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public int getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public int getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}

	public Customer getCustomerCard() {
		return customerCard;
	}

	public void setCustomerCard(Customer customerCard) {
		this.customerCard = customerCard;
	}

	@Override
	public String toString() {
		return "SavedCardDetails [sno=" + sno + ", cardHolderName=" + cardHolderName + ", CardNumber=" + CardNumber
				+ ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", customerCard=" + customerCard
				+ "]";
	}

	
}
