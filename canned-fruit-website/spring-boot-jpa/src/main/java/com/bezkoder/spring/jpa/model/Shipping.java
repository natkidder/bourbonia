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

//  @CreationTimestamp
//  @Column(name = "created_on")
//  private Date createdOn;
//
//  @UpdateTimestamp
//  @Column(name = "updated_on")
//  private Date updatedOn;
//  
  public Shipping() {
  }
  public Shipping(long id, String type, double price) {
	super();
	this.id = id;
	this.type = type;
	this.price = price;
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

@Override
public String toString() {
	return "Shipping [id=" + id + ", type=" + type + ", price=" + price + "]";
}

}
