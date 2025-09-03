package com.bezkoder.spring.jpa.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "canned_fruit")
public class CannedFruit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "fruit")
	private String fruit;

	@ManyToOne(fetch = FetchType.EAGER)
	//@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	@JoinColumn(name="medium_id")
	private Medium medium;
	
	// halved, diced, sectioned, etc.
	@Column(name="unit_type")
	private String unitType;

	@Column(name = "volume")
	private int volume;

	@Column(name = "container")
	private String container;
	
	@Column(name = "price_per")
	private BigDecimal pricePer;

	public CannedFruit() {

	}

	public CannedFruit(String fruit, Medium medium, String unitType, int volume, String container, BigDecimal pricePer) {
		super();
		this.fruit = fruit;
		this.medium = medium;
		this.unitType = unitType;
		this.volume = volume;
		this.container = container;
		this.pricePer = pricePer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public Medium getMedium() {
		return medium;
	}

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public void setMedium(Medium medium) {
		this.medium = medium;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public BigDecimal getPricePer() {
		return pricePer;
	}

	public void setPricePer(BigDecimal pricePer) {
		this.pricePer = pricePer;
	}

	/* medium can be null as part of the response to posting a new customer order
	 * TODO see if you can make the call asynchronous or something
	 */
	@Override
	public String toString() {
		return "CannedFruit [id=" + id + ", fruit=" + fruit + ", medium=" + (medium == null ? "" : medium.toString()) + ", unitType=" + unitType
				+ ", volume=" + volume + ", container=" + container + ", pricePer=" + pricePer + "]";
	}


}
