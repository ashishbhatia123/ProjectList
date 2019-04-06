package com.example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Orders
{
	@Id
	@Column(name="order_id",length=10)
	private String orderId;
	@Column(name="purchase_date",length=50)
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="delivery_address")
	private Address deliveryAddress;
	@Column(name="deliver_date",length=50)
	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	@OneToOne(cascade=CascadeType.ALL)
	private  Invoice  invoice;	
	@Column(name="status",length=20)
	private String orderStatus;
	@Column(name="subtotal",length=10)
	private Double subTotal;
	@Column(name="payment_acc_no",length=16)
	private long paymentAccNo;
	
	@Column(name="payment_option",length=20)
	private String paymentOption;
	
	@ManyToMany
	@JoinTable(name="orders_product",
	joinColumns=@JoinColumn(name="order_id"),
	inverseJoinColumns=@JoinColumn(name="prod_id"))
	private List<Product> ordersProduct  = new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="cartOrder")
//	@JoinTable(name="cart_order",
//			joinColumns=@JoinColumn(name="order_id"),
//			inverseJoinColumns=@JoinColumn(name="cart_id"))
	private List<Cart> cart=new ArrayList<>();
	
	public Orders() 
	{
		super();
	}

	public Orders(String orderId, Date purchaseDate, Address deliveryAddress, Date deliveryDate, Invoice invoice,
			String orderStatus, Double subTotal, long paymentAccNo, String paymentOption, List<Product> ordersProduct,
			List<Cart> cart) {
		super();
		this.orderId = orderId;
		this.purchaseDate = purchaseDate;
		this.deliveryAddress = deliveryAddress;
		this.deliveryDate = deliveryDate;
		this.invoice = invoice;
		this.orderStatus = orderStatus;
		this.subTotal = subTotal;
		this.paymentAccNo = paymentAccNo;
		this.paymentOption = paymentOption;
		this.ordersProduct = ordersProduct;
		this.cart = cart;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public long getPaymentAccNo() {
		return paymentAccNo;
	}

	public void setPaymentAccNo(long paymentAccNo) {
		this.paymentAccNo = paymentAccNo;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public List<Product> getOrdersProduct() {
		return ordersProduct;
	}

	public void setOrdersProduct(List<Product> ordersProduct) {
		this.ordersProduct = ordersProduct;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", purchaseDate=" + purchaseDate + ", deliveryAddress=" + deliveryAddress
				+ ", deliveryDate=" + deliveryDate + ", invoice=" + invoice + ", orderStatus=" + orderStatus
				+ ", subTotal=" + subTotal + ", paymentAccNo=" + paymentAccNo + ", paymentOption=" + paymentOption
				+ ", ordersProduct=" + ordersProduct + ", cart=" + cart + "]";
	}

	

}