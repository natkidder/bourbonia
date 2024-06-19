package com.jamesholmes.minihr;

import java.util.ArrayList;

import junit.framework.TestCase;

public class EmployeeSearchServiceTest extends TestCase {

	public EmployeeSearchServiceTest(String arg0) {
		super(arg0);
	}

	public void setUp() {
		service = new EmployeeSearchService();
	}
	
	public void testSearchByName() {
		String name ="Jim";
		ArrayList l = service.searchByName(name);
		assertEquals("Number of results", 2, l.size());
	}

	public void testSearchBySSN() {
		String ssn ="333-33-3333";
		ArrayList l = service.searchBySsNum(ssn);
		assertEquals("Number of results", 1, l.size());
		Employee e = (Employee) l.get(0);
		assertEquals("SSN", ssn, e.getSsNum());
	}

	public void testSearchByUnknownSSN() {
		String ssn ="999099-49493939";
		ArrayList l = service.searchBySsNum(ssn);
		assertEquals("Number of results", 0, l.size());
	}

	private EmployeeSearchService service;
}
