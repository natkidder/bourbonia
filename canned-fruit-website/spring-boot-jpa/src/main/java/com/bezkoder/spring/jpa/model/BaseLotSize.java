package com.bezkoder.spring.jpa.model;

public enum BaseLotSize {
	MINUTE(8),
	SMALL(12),
	AVERAGE(18),
	LARGE(24),
	EXTRALARGE(36);
	
	private final int lotSize;
	
	BaseLotSize(int lotSize) {
		this.lotSize = lotSize;
	}
	
	public int getLotSize() {
		return this.lotSize;
	}
}
