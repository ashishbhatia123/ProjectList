package com.cg.bean;

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
	@Column(name="prodId",length=10)
	private String prodId;
	@Column(name="name",length=70)
	private String name;
	@Column(name="sizes",length=5)
	private String sizes;
	@Column(name="initalQuantity",length=5)	
	private int initialQuantity;
	@Column(name="availableQuantity",length=5)	
	private int availableQuantity;
	@Column(name="price",length=6)
	private double price;
	@Column(name="rating",length=5)
	private double rating;
	@Column(name="prodCategory",length=50)
	private String prodCategory;
	@Column(name="discount",length=5)
	private double prodDiscount;
	
	@ManyToMany(mappedBy="prodCoupon")
//	@JoinTable(name="product_coupon",
//				joinColumns=@JoinColumn(name="prod_id")
//				,inverseJoinColumns=@JoinColumn(name="coupon_id"))
	private List<Coupon> prodCoupon;
	
	
	
	@ManyToMany
	@JoinTable(name="merchantProduct",joinColumns=@JoinColumn(name="merchantId"),
				inverseJoinColumns=@JoinColumn(name="prodId"))
	private List<Merchant> merchantProduct;
	
	
	@ManyToMany
	@JoinTable(name="prodImages",joinColumns=@JoinColumn(name="prodId"),
			inverseJoinColumns=@JoinColumn(name="imageId"))
	private List<Image> prodImages;

	
	@ManyToMany(mappedBy="prodFeedback")
//	@JoinTable(name="product_feedback"
//			,joinColumns=@JoinColumn(name="prod_id")
//			,inverseJoinColumns= @JoinColumn(name="feedback_id")
//			)
	private List<Feedback> prodFeedback;
	
	@ManyToMany(mappedBy="wishlistProd")
//	@JoinTable(name="wishlist_product",
//				joinColumns=@JoinColumn(name="prod_id"),
//				inverseJoinColumns=@JoinColumn(name="wishlist_id"))
	private List<WishList> wishlist;
	
	@ManyToMany(mappedBy="ordersProduct")
//	@JoinTable(name="orders_product",
//				joinColumns=@JoinColumn(name="order_id"),
//				inverseJoinColumns=@JoinColumn(name="prod_id"))
	private List<Orders> ordersProduct;
	
	@ManyToMany
	@JoinTable(name="cartProduct",
				joinColumns=@JoinColumn(name="cartId"),
				inverseJoinColumns=@JoinColumn(name="prodId"))
	private List<Cart> cartProduct;

	@ManyToMany(mappedBy="prodImages")
//	@JoinTable(name="prod_images",
//			joinColumns=@JoinColumn(name="image_id"),
//			inverseJoinColumns=@JoinColumn(name="prod_id")
//			)
	private List<Product> productImg;
	
	public Product() 
	{
		super();
	}

	public Product(String prodId , String name, String sizes, int initialQuantity, int availableQuantity,
			double price, double rating, String prodCategory, double prodDiscount, List<Coupon> prodCoupon,
			List<Merchant> merchantProduct, List<Image> prodImages, List<Feedback> prodFeedback,
			List<WishList> wishlist, List<Orders> ordersProduct, List<Cart> cartProduct, List<Product> productImg) {
		super();
		this.prodId = prodId ;
		this.name = name;
		this.sizes = sizes;
		this.initialQuantity = initialQuantity;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.rating = rating;
		this.prodCategory = prodCategory;
		this.prodDiscount = prodDiscount;
		this.prodCoupon = prodCoupon;
		this.merchantProduct = merchantProduct;
		this.prodImages = prodImages;
		this.prodFeedback = prodFeedback;
		this.wishlist = wishlist;
		this.ordersProduct = ordersProduct;
		this.cartProduct = cartProduct;
		this.productImg = productImg;
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

	public List<Coupon> getProdCoupon() {
		return prodCoupon;
	}

	public void setProdCoupon(List<Coupon> prodCoupon) {
		this.prodCoupon = prodCoupon;
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

	public List<Product> getProductImg() {
		return productImg;
	}

	public void setProductImg(List<Product> productImg) {
		this.productImg = productImg;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", name=" + name + ", sizes=" + sizes + ", initialQuantity="
				+ initialQuantity + ", availableQuantity=" + availableQuantity + ", price=" + price + ", rating="
				+ rating + ", prodCategory=" + prodCategory + ", prodDiscount=" + prodDiscount + ", prodCoupon="
				+ prodCoupon + ", merchantProduct=" + merchantProduct + ", prodImages=" + prodImages + ", prodFeedback="
				+ prodFeedback + ", wishlist=" + wishlist + ", ordersProduct=" + ordersProduct + ", cartProduct="
				+ cartProduct + ", productImg=" + productImg + "]";
	}

	
	
}
