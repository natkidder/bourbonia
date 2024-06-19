package com.jamesholmes.minihr;

import servletunit.struts.CactusStrutsTestCase;

public class SearchActionStrutsTest extends CactusStrutsTestCase {

	public SearchActionStrutsTest(String testName) {
		super(testName);
	}

	public void setUp() throws Exception {
		super.setUp();
		setRequestPathInfo("/search");		
	}

	public void testSearchByName() throws Exception {
		addRequestParameter("name","Jim");
		actionPerform();
		assertNotNull("Results are null",
		  ((SearchForm) getActionForm()).getResults());				
		verifyInputForward();
	}
}

