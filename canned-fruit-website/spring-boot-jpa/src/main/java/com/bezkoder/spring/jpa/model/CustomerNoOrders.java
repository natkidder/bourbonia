package com.bezkoder.spring.jpa.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.annotations.Immutable;
import org.springframework.context.annotation.Scope;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "customers_no_orders")
@Immutable
@Scope("prototype")
public class CustomerNoOrders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "business_name")
	private String businessName;
	
	@Column(name = "outlet_name")
	private String outletName;
	
	@Column(name = "poc_first")
	private String pocFirst;
	
	@Column(name = "poc_last")
	private String pocLast;
	
//	@Column(name = "poc_phone")
//	private String pocPhone;
//	
	@Column(name = "poc_email", unique=true, nullable=false)
	private String pocEmail;
	
//	@Column(name = "addr_type")
//	private String addrType;
//	
//	@Column(name = "street1")
//	private String street1;
//	
//	@Column(name = "street2")
//	private String street2;
//	
//	@Column(name = "city")
//	private String city;
//	
//	@Column(name = "state")
//	private String state;
//	
//	@Column(name = "zip")
//	private String zip;
	
	//TODO have the view be just customer and give it a @OneToMany foreign key to addresses 
//    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
//    @JoinColumn(name="customer_id")
//	private List<Address> addresses = new ArrayList<>();

	public CustomerNoOrders() {}
//	public CustomerNoOrders(long id, String businessName, String outletName, String pocFirst, String pocLast, String pocPhone, String pocEmail,
//			String addrType, String street1, String street2,  String city, String state, String zip) {
	public CustomerNoOrders(long id, String businessName, String outletName, String pocFirst, String pocLast, String pocEmail) {
		super();
		this.id = id;
		this.businessName = businessName;
		this.outletName = outletName;
		this.pocFirst = pocFirst;
		this.pocLast = pocLast;
//		this.pocPhone = pocPhone;
		this.pocEmail = pocEmail;
//		this.addrType = addrType;
//		this.street1 = street1;
//		this.street2 = street2;
//		this.city = city;
//		this.state = state;
//		this.zip = zip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getOutletName() {
		return outletName;
	}
	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}
	public String getPocFirst() {
		return pocFirst;
	}

	public void setPocFirst(String pocFirst) {
		this.pocFirst = pocFirst;
	}

	public String getPocLast() {
		return pocLast;
	}

	public void setPocLast(String pocLast) {
		this.pocLast = pocLast;
	}

//	public String getPocPhone() {
//		return pocPhone;
//	}
//
//	public void setPocPhone(String pocPhone) {
//		this.pocPhone = pocPhone;
//	}
//
	public String getPocEmail() {
		return pocEmail;
	}

	public void setPocEmail(String pocEmail) {
		this.pocEmail = pocEmail;
	}

//	public String getAddrType() {
//		return addrType;
//	}
//	public void setAddrType(String addrType) {
//		this.addrType = addrType;
//	}
//	public String getStreet1() {
//		return street1;
//	}
//	public void setStreet1(String street1) {
//		this.street1 = street1;
//	}
//	public String getStreet2() {
//		return street2;
//	}
//	public void setStreet2(String street2) {
//		this.street2 = street2;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
//	public String getZip() {
//		return zip;
//	}
//	public void setZip(String zip) {
//		this.zip = zip;
//	}
	@Override
	public String toString() {
		return "CustomerNoOrders [id=" + id + ", businessName=" + businessName + ", outletName="
				+ outletName + ", pocFirst=" + pocFirst + ", pocLast=" + pocLast + ", pocEmail=" + pocEmail + "]";
//		, pocPhone="
//				+ pocPhone + ", pocEmail=" + pocEmail + ", addrType=" + addrType + ", street1="
//				+ street1 + ", street2=" + street2 + ", city=" + city + ", state=" + state
//				+ ", zip=" + zip + "]";
	}
}
