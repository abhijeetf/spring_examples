package com.simple.entity;

import java.math.BigDecimal;

public class Product implements DomainObject {
	private Integer id;
	private String desc;
	private BigDecimal price;
	private String imageUrl;
	
	public Product() {
	}
	
	public Product(Integer id, String desc, BigDecimal price, String imageUrl) {
		super();
		this.id = id;
		this.desc = desc;
		this.price = price;
		this.imageUrl = imageUrl;
	}



	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
