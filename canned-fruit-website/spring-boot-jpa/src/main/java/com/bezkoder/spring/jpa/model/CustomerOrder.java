package com.bezkoder.spring.jpa.model;

import java.sql.Date;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

// TODO add a bill to address
@Entity
@Table(name = "customer_order")
@Scope("prototype")
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    //@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
	private Customer customer = new Customer();
    
    @Column(name = "name_on_card")
    private String nameOnCard;
    
	@Column(name = "card_nbr")
	private String cardNbr;
	
	@Column(name = "expiration_dt")
	private Date expirationDt;
	
	@Column(name = "cvv")
	private String cvv;
	
	@Column(name = "order_status")
	private String orderStatus;
	
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
    @JoinColumn(name="cust_ord_id")
	private List<CustomerOrderItem> customerOrderItems = new ArrayList<>();

    //@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
    @ManyToOne(fetch = FetchType.EAGER)  // meaning many customer orders per shipping terms
    @JoinColumn(name="shipping_id")
	private Shipping shipping = new Shipping();
    
    // TODO see why we get a ERROR: update or delete on table "address" violates foreign key constraint "[constraint]" on table "customer_order" when we update the address
    @ManyToOne(fetch=FetchType.EAGER)  // meaning many customer orders per shipping address
    @JoinColumn(name="ship_addr_id")
	private Address shipToAddress = new Address();
    
    public CustomerOrder() {}

//	public CustomerOrder(long id, Customer customer, String nameOnCard, String cardNbr, Date expirationDt, String cvv, String orderStatus,
//			List<CustomerOrderItem> customerOrderItems, Shipping shipping, Address shipToAddress) {
    public CustomerOrder(long id, Customer customer, String nameOnCard, String cardNbr, Date expirationDt, String cvv, String orderStatus, 
    		List<CustomerOrderItem> customerOrderItems, Shipping shipping, Address shipToAddress) {
		super();
		this.id = id;
		this.customer = customer;
		this.nameOnCard = nameOnCard;
		this.cardNbr = cardNbr;
		this.expirationDt = expirationDt;
		this.cvv = cvv;
		this.orderStatus = orderStatus;
		this.customerOrderItems = customerOrderItems;
		this.shipping = shipping;
		this.shipToAddress = shipToAddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNbr() {
		return cardNbr;
	}

	public void setCardNbr(String cardNbr) {
		this.cardNbr = cardNbr;
	}

	public Date getExpirationDt() {
		return expirationDt;
	}

	public void setExpirationDt(Date expirationDt) {
		this.expirationDt = expirationDt;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public List<CustomerOrderItem> getCustomerOrderItems() {
		return customerOrderItems;
	}

	public void setCustomerOrderItems(List<CustomerOrderItem> customerOrderItems) {
		this.customerOrderItems = customerOrderItems;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public Address getShipToAddress() {
		return shipToAddress;
	}

	public void setShipToAddress(Address shipToAddress) {
		this.shipToAddress = shipToAddress;
	}

	@Override
	public String toString() {
        String orderItems = customerOrderItems.stream()
                .map(Object::toString) // Maps each object to its String representation using toString()
                .collect(Collectors.joining("\n"));
		return "CustomerOrder [id=" + id + ", customer=" + customer.toString() + ", nameOnCard=" + nameOnCard + ", cardNbr="
				+ cardNbr + ", expirationDt=" + expirationDt + ", cvv=" + cvv + ", orderStatus=" + orderStatus + ", customerOrderItems="
				+ orderItems + ", shipping=" + shipping.toString() + ", shitToAddress=" + shipToAddress.toString() + "]";
	}


}
