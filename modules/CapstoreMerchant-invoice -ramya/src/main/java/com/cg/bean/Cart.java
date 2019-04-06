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
@Table(name="cart")
public class Cart
{
	@Id
	@Column(name="cartId")
	private String cartId;
	
	@ManyToMany(mappedBy="cartProduct")
//	@JoinTable(name="cart_product",
//		joinColumns=@JoinColumn(name="cart_id"),
//		inverseJoinColumns=@JoinColumn(name="prod_id")
//	)
	private List<Product> products = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="cartOrder",
			joinColumns=@JoinColumn(name="cartId"),
			inverseJoinColumns=@JoinColumn(name="orderId"))
	private List<Orders> cartOrder;
	public Cart() 
	{
		super();
	}
	public Cart(String cartId, List<Product> products, List<Orders> cartOrder) {
		super();
		this.cartId = cartId;
		this.products = products;
		this.cartOrder = cartOrder;
	}

	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Orders> getCartOrder() {
		return cartOrder;
	}
	public void setCartOrder(List<Orders> cartOrder) {
		this.cartOrder = cartOrder;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + ", cartOrder=" + cartOrder + "]";
	}
	
}
