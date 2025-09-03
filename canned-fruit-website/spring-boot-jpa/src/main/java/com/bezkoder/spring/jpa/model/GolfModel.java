package com.bezkoder.spring.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "golf")
public class GolfModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "golf_name")
	private String golfName;
	
    // TODO see whay it always add the customerid column in addition to the foreign-keyed customer_id column
	//@Column
	//private int customerID;

	public GolfModel(long id, String golfName, int customerID) {
		super();
		this.id = id;
		this.golfName = golfName;
		//this.customerID = customerID;
	}

	public GolfModel() {}

	public GolfModel(long id, String golfName) {
		super();
		this.id = id;
		this.golfName = golfName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGolfName() {
		return golfName;
	}

	public void setGolfName(String golfName) {
		this.golfName = golfName;
	}

	@Override
	public String toString() {
		return "GolfModel [id=" + id + ", golfName=" + golfName + "]";
	}
	
}
