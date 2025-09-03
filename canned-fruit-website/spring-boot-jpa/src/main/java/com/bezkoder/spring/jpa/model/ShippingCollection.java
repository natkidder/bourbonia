package com.bezkoder.spring.jpa.model;

import java.util.List;

public class ShippingCollection {

	List<Shipping> shippings;

	public ShippingCollection(List<Shipping> shippings) {
		this.shippings = shippings;
	}

	public List<Shipping> getShippings() {
		return shippings;
	}

	public void setShippings(List<Shipping> shippings) {
		this.shippings = shippings;
	}

}
