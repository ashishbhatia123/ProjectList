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
@Table(name="wishlist")
public class WishList 
{
	@Id
	@Column(name="wishlistId")
	private String wishlistId;
	@ManyToMany
	@JoinTable(name="wishlistProduct",
				joinColumns=@JoinColumn(name="prodId"),
				inverseJoinColumns=@JoinColumn(name="wishlistId"))
	private List<Product> wishlistProd=new ArrayList<>();
	
	public WishList()
	{
		super();
	}

	public WishList(String wishlistId, List<Product> wishlistProd) {
		super();
		this.wishlistId =wishlistId;
		this.wishlistProd = wishlistProd;
	}

	public String getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(String wishlistId) {
		this.wishlistId = wishlistId;
	}

	public List<Product> getWishlistProd() {
		return wishlistProd;
	}

	public void setWishlistProd(List<Product> wishlistProd) {
		this.wishlistProd = wishlistProd;
	}

	@Override
	public String toString() {
		return "WishList [wishlistId=" + wishlistId + ", wishlistProd=" + wishlistProd + "]";
	}

	
}
