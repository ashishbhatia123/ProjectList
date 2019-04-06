package com.example.model;

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
@Table(name="product")
public class Product
{
	@Id
	@Column(name="prod_id",length=10)
	private String prodId;
	@Column(name="name",length=70)
	private String name;
	@Column(name="sizes",length=5)
	private String sizes;
	@Column(name="inital_quantity",length=5)	
	private int initialQuantity;
	@Column(name="available_quantity",length=5)	
	private int availableQuantity;
	@Column(name="price",length=6)
	private double price;
	@Column(name="rating",length=5)
	private double rating;
	@Column(name="prodCategory",length=50)
	private String prodCategory;
	@Column(name="discount",length=5)
	private double prodDiscount;
	@Column(name="url")
	private String url;
	
	
	@ManyToMany(mappedBy="prodCoupon")
//	@JoinTable(name="product_coupon",
//				joinColumns=@JoinColumn(name="prod_id")
//				,inverseJoinColumns=@JoinColumn(name="coupon_id"))
	private List<Coupon> productCoupon=new ArrayList<>();
	
	
	
	@ManyToMany
	@JoinTable(name="merchant_product",joinColumns=@JoinColumn(name="merchant_id"),
				inverseJoinColumns=@JoinColumn(name="prod_id"))
	private List<Merchant> merchantProduct=new ArrayList<>();
	
	
	@ManyToMany
	@JoinTable(name="prod_images",joinColumns=@JoinColumn(name="prod_id"),
			inverseJoinColumns=@JoinColumn(name="image_id"))
	private List<Image> prodImages=new ArrayList<>();

	
	@ManyToMany(mappedBy="prodFeedback")
//	@JoinTable(name="product_feedback"
//			,joinColumns=@JoinColumn(name="prod_id")
//			,inverseJoinColumns= @JoinColumn(name="feedback_id")
//			)
	private List<Feedback> prodFeedback=new ArrayList<>();
	
	@ManyToMany(mappedBy="wishlistProd")
//	@JoinTable(name="wishlist_product",
//				joinColumns=@JoinColumn(name="prod_id"),
//				inverseJoinColumns=@JoinColumn(name="wishlist_id"))
	private List<WishList> wishlist=new ArrayList<>();
	
	@ManyToMany(mappedBy="ordersProduct")
//	@JoinTable(name="orders_product",
//				joinColumns=@JoinColumn(name="order_id"),
//				inverseJoinColumns=@JoinColumn(name="prod_id"))
	private List<Orders> ordersProduct=new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="cart_product",
				joinColumns=@JoinColumn(name="cart_id"),
				inverseJoinColumns=@JoinColumn(name="prod_id"))
	private List<Cart> cartProduct=new ArrayList<>();


	
	public Product() 
	{
		super();
	}



	public Product(String prodId, String name, String sizes, int initialQuantity, int availableQuantity, double price,
			double rating, String prodCategory, double prodDiscount, String url, List<Coupon> productCoupon,
			List<Merchant> merchantProduct, List<Image> prodImages, List<Feedback> prodFeedback,
			List<WishList> wishlist, List<Orders> ordersProduct, List<Cart> cartProduct) {
		super();
		this.prodId = prodId;
		this.name = name;
		this.sizes = sizes;
		this.initialQuantity = initialQuantity;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.rating = rating;
		this.prodCategory = prodCategory;
		this.prodDiscount = prodDiscount;
		this.url = url;
		this.productCoupon = productCoupon;
		this.merchantProduct = merchantProduct;
		this.prodImages = prodImages;
		this.prodFeedback = prodFeedback;
		this.wishlist = wishlist;
		this.ordersProduct = ordersProduct;
		this.cartProduct = cartProduct;
	}



	public String getProdId() {
		return prodId;
	}



	public void setProdId(String prodId) {
		this.prodId = prodId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSizes() {
		return sizes;
	}



	public void setSizes(String sizes) {
		this.sizes = sizes;
	}



	public int getInitialQuantity() {
		return initialQuantity;
	}



	public void setInitialQuantity(int initialQuantity) {
		this.initialQuantity = initialQuantity;
	}



	public int getAvailableQuantity() {
		return availableQuantity;
	}



	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}



	public String getProdCategory() {
		return prodCategory;
	}



	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}



	public double getProdDiscount() {
		return prodDiscount;
	}



	public void setProdDiscount(double prodDiscount) {
		this.prodDiscount = prodDiscount;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public List<Coupon> getProductCoupon() {
		return productCoupon;
	}



	public void setProductCoupon(List<Coupon> productCoupon) {
		this.productCoupon = productCoupon;
	}



	public List<Merchant> getMerchantProduct() {
		return merchantProduct;
	}



	public void setMerchantProduct(List<Merchant> merchantProduct) {
		this.merchantProduct = merchantProduct;
	}



	public List<Image> getProdImages() {
		return prodImages;
	}



	public void setProdImages(List<Image> prodImages) {
		this.prodImages = prodImages;
	}



	public List<Feedback> getProdFeedback() {
		return prodFeedback;
	}



	public void setProdFeedback(List<Feedback> prodFeedback) {
		this.prodFeedback = prodFeedback;
	}



	public List<WishList> getWishlist() {
		return wishlist;
	}



	public void setWishlist(List<WishList> wishlist) {
		this.wishlist = wishlist;
	}



	public List<Orders> getOrdersProduct() {
		return ordersProduct;
	}



	public void setOrdersProduct(List<Orders> ordersProduct) {
		this.ordersProduct = ordersProduct;
	}



	public List<Cart> getCartProduct() {
		return cartProduct;
	}



	public void setCartProduct(List<Cart> cartProduct) {
		this.cartProduct = cartProduct;
	}



	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", name=" + name + ", sizes=" + sizes + ", initialQuantity="
				+ initialQuantity + ", availableQuantity=" + availableQuantity + ", price=" + price + ", rating="
				+ rating + ", prodCategory=" + prodCategory + ", prodDiscount=" + prodDiscount + ", url=" + url
				+ ", productCoupon=" + productCoupon + ", merchantProduct=" + merchantProduct + ", prodImages="
				+ prodImages + ", prodFeedback=" + prodFeedback + ", wishlist=" + wishlist + ", ordersProduct="
				+ ordersProduct + ", cartProduct=" + cartProduct + "]";
	}

	
	
	
}
