package com.bezkoder.spring.jpa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "addrType")
	private String addrType; // home, business, delivery, etc.

	@Column(name = "street1")
	private String street1;
	
	@Column(name = "street2")
	private String street2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip")
	private String zip;

/*    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
    @JoinColumn(name="cust_order_id")
	private List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>(); */

	public Address() {}
	public Address(long id, String addrType, String street1, String street2, String city, String state, String zip) { //, List<CustomerOrder> customerOrders) {
		super();
		this.id = id;
		this.addrType = addrType;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		//this.customerOrders = customerOrders;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddrType() {
		return addrType;
	}
	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
/*	public List<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}
	public void setCustomerOrder(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	} */
	@Override
	public String toString() {
	/*	String joinedOrders = this.getCustomerOrders().stream()
                .map(CustomerOrder::toString) // Map objects to their names (Strings)
                .collect(Collectors.joining(", ")); */
		return "Address [id=" + id + ", addrType=" + addrType + ", street1=" + street1 + ", street2=" + street2 + ", city="
				+ city + ", state=" + state + ", zip=" + zip + "]"; // ", customerOrders= " + joinedOrders + "]";
	}
	
}
