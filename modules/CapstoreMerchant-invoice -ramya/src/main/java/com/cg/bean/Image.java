package com.cg.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class Image 
{
	@Id
	@Column(name="imageId")
	private String imageId;
	@Column(name="url")
	private String url;
	
	@ManyToMany(mappedBy="prodImages")
//	@JoinTable(name="prod_images",
//			joinColumns=@JoinColumn(name="image_id"),
//			inverseJoinColumns=@JoinColumn(name="prod_id")
//			)
	private List<Product> productImg;
	
	public Image()
	{
		super();
	}

	public Image(String imageId, String url, List<Product> productImg) {
		super();
		this.imageId = imageId;
		this.url = url;
		this.productImg = productImg;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Product> getProductImg() {
		return productImg;
	}

	public void setProductImg(List<Product> productImg) {
		this.productImg = productImg;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", url=" + url + ", productImg=" + productImg + "]";
	}


}
