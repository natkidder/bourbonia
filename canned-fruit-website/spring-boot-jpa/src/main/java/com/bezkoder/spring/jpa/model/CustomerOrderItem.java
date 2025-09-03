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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "customer_order_item")
@Scope("prototype")
public class CustomerOrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    //@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="canned_fruit_id")
	private CannedFruit cannedFruit = new CannedFruit();
    
	@Column(name = "cnt")
	private int cnt;
    
    public CustomerOrderItem() {}

	public CustomerOrderItem(long id, CannedFruit cannedFruit, int cnt) {
		super();
		this.id = id;
		this.cannedFruit = cannedFruit;
		this.cnt = cnt;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CannedFruit getCannedFruit() {
		return cannedFruit;
	}

	public void setCannedFruit(CannedFruit cannedFruit) {
		this.cannedFruit = cannedFruit;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "CustomerOrderItem [id=" + id + ", Count=" + cnt + ", cannedFruit=\n" + this.cannedFruit.toString() + "]";
	}
    
}
