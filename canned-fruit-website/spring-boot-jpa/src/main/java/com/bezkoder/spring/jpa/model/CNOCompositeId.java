package com.bezkoder.spring.jpa.model;

public class CNOCompositeId {
	private int c_id;
	private int a_id;
	public CNOCompositeId(int c_id, int a_id) {
		super();
		this.c_id = c_id;
		this.a_id = a_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	@Override
	public String toString() {
		return "CNOCompositeId [c_id=" + c_id + ", a_id=" + a_id + "]";
	}
	
}
