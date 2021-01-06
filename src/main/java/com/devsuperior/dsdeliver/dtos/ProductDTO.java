package com.devsuperior.dsdeliver.dtos;

import java.math.BigDecimal;

import com.devsuperior.dsdeliver.entities.Product;

public class ProductDTO {
	
	private Long id;
	
	private String name;
	
	private BigDecimal price;
	
	private String description;
	
	private String imageUri;
	
	public ProductDTO() {
		
	}

	public ProductDTO(Product p) {
		this.id = p.getId();
		this.name = p.getName();
		this.price = p.getPrice();
		this.description = p.getDescription();
		this.imageUri = p.getImageUrl();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	
	
	
	
}
