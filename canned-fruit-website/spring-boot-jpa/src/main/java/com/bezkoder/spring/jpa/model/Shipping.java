package com.bezkoder.spring.jpa.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Scope;

import jakarta.persistence.*;

@Entity
@Table(name = "Shipping")
@Scope("prototype")
public class Shipping {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "type")
  private String type;

  @Column(name = "price")
  private double price;

  @CreationTimestamp
  @Column(name = "created_on")
  private Date createdOn;

  @UpdateTimestamp
  @Column(name = "updated_on")
  private Date updatedOn;
  
  public Shipping() {
  }

  public Shipping(String type, double price) {
    this.type = type;
    this.price = price;
  }

  public long getId() {
    return id;
  }

  public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public Date getCreatedOn() {
	return createdOn;
}

public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}

public Date getUpdatedOn() {
	return updatedOn;
}

public void setUpdatedOn(Date updatedOn) {
	this.updatedOn = updatedOn;
}

@Override
public String toString() {
	return "Shipping [id=" + id + ", type=" + type + ", price=" + price + ", createdOn=" + createdOn + ", updatedOn="
			+ updatedOn + "]";
}

}
