package com.bezkoder.spring.jpa.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
@Table(name = "customer")
@Scope("prototype")
public class Customer {

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
	
	@Column(name = "poc_phone")
	private String pocPhone;
	
	@Column(name = "poc_email", unique=true, nullable=false)
	private String pocEmail;
	
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
    @JoinColumn(name="customer_id")
	private List<Address> addresses = new ArrayList<>();

	public Customer() {}
	public Customer(long id, String businessName, String outletName, String pocFirst, String pocLast, String pocPhone, String pocEmail,
			List<Address> addresses) {
		super();
		this.id = id;
		this.businessName = businessName;
		this.outletName = outletName;
		this.pocFirst = pocFirst;
		this.pocLast = pocLast;
		this.pocPhone = pocPhone;
		this.pocEmail = pocEmail;
		this.addresses = addresses;
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

	public String getPocPhone() {
		return pocPhone;
	}

	public void setPocPhone(String pocPhone) {
		this.pocPhone = pocPhone;
	}

	public String getPocEmail() {
		return pocEmail;
	}

	public void setPocEmail(String pocEmail) {
		this.pocEmail = pocEmail;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		if (addresses != null) {
			this.addresses.clear();
			//this.addresses = Stream.concat(addresses.stream(), this.addresses.stream()).collect(Collectors.toList());
			for (Address addr : addresses) {
				this.addresses.add(addr);
			}
		}
	}
	@Override
	public String toString() {
		StringBuilder sbuild = new StringBuilder("Customer [id=" + id + ", businessName=" + businessName + ", outletName=" + outletName + ", pocFirst="
				+ pocFirst + ", pocLast=" + pocLast + ", pocPhone=" + pocPhone + ", pocEmail=" + pocEmail);
        for (Address addr: this.getAddresses()) {
        	sbuild.append("Address: "+ addr.toString());
        }
        return sbuild.toString();

	}
}
