package com.jamesholmes.minihr;

import java.util.ArrayList;
import junit.framework.TestCase;

public class EmployeeSearchServiceTest extends TestCase {
  private EmployeeSearchService service;

  public EmployeeSearchServiceTest(String arg0) {
    super(arg0);
  }

  public void setUp() {
  	super.setUp();
    service = new EmployeeSearchService();
  }
	
  public void tearDown() {
    super.tearDown(); 
  }
	
  public void testSearchByName() {
    String name = "Jim";
    ArrayList results = service.searchByName(name);
    assertEquals("Number of results", 2, results.size());
  }

  public void testSearchBySSN() {
    String ssn = "333-33-3333";
    ArrayList results = service.searchBySsNum(ssn);
    assertEquals("Number of results", 1, results.size());
    Employee e = (Employee) results.get(0);
    assertEquals("SSN", ssn, e.getSsNum());
  }

  public void testSearchByUnknownSSN() {
    String ssn = "999099-49493939";
    ArrayList results = service.searchBySsNum(ssn);
    assertEquals("Number of results", 0, results.size());
  }
}
