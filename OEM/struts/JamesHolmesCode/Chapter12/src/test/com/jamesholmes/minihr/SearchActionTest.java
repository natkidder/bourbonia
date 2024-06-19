package com.jamesholmes.minihr;

import servletunit.struts.MockStrutsTestCase;

public class SearchActionTest extends MockStrutsTestCase {

	public SearchActionTest(String testName) {
		super(testName);
	}

	public void setUp() throws Exception {
		super.setUp();
	}

	public void testSearchByName() throws Exception {
		setRequestPathInfo("/search");		
		addRequestParameter("name","Jim");
		actionPerform();
		assertNotNull("Results are null",
		  ((SearchForm) getActionForm()).getResults());				
		verifyInputForward();
	}
}

