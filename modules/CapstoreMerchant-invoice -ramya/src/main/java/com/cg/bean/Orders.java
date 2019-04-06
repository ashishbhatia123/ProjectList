package com.cg.bean;

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
	@Column(name="orderId",length=10)
	private String orderId;
	@Column(name="purchaseDate",length=50)
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="deliveryAddress")
	private Address deliveryAddress;
	@Column(name="deliverDate",length=50)
	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	@OneToOne(cascade=CascadeType.ALL)
	private  Invoice  invoice;	
	@Column(name="status",length=20)
	private String orderStatus;
	@Column(name="subtotal",length=10)
	private Double subTotal;
	@Column(name="paymentAccNo",length=16)
	private long paymentAccNo;
	
	@ManyToMany
	@JoinTable(name="ordersProduct",
	joinColumns=@JoinColumn(name="orderId"),
	inverseJoinColumns=@JoinColumn(name="prodId"))
	private List<Product> ordersProduct  = new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="cartOrder")
//	@JoinTable(name="cart_order",
//			joinColumns=@JoinColumn(name="order_id"),
//			inverseJoinColumns=@JoinColumn(name="cart_id"))
	private List<Cart> cart;
	
	public Orders() 
	{
		super();
	}

	public Orders(String orderId, Date purchaseDate, Address deliveryAddress, Date deliveryDate, Invoice invoice,
			String orderStatus, Double subTotal, long paymentAccNo, List<Product> ordersProduct, List<Cart> cart) {
		super();
		this.orderId = orderId;
		this.purchaseDate = purchaseDate;
		this.deliveryAddress = deliveryAddress;
		this.deliveryDate = deliveryDate;
		this.invoice = invoice;
		this.orderStatus = orderStatus;
		this.subTotal = subTotal;
		this.paymentAccNo =paymentAccNo;
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
				+ ", subTotal=" + subTotal + ", paymentAccNo=" + paymentAccNo + ", ordersProduct=" + ordersProduct
				+ ", cart=" + cart + "]";
	}

	

	
}