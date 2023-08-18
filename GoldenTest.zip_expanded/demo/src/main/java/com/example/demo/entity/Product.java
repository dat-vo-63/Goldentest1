package com.example.demo.entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table ( name ="product")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long productId;
@Column( name = "description",columnDefinition = "VARCHAR(550)")
private String description;
public long getProductId() {
	return productId;
}
public void setProductId(long productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
private String productName;
private double productPrice;
private String image;
public Product(long productId, String image,String productName, String description,double productPrice) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.productPrice = productPrice;
	this.image = image;
	this.description = description;
}
public Product() {
	
}

}
