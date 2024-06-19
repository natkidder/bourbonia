package com.jamesholmes.minihr;

import org.apache.cactus.ServletTestCase;
import org.apache.cactus.WebRequest;
import org.apache.struts.action.ActionServlet;

public class SearchActionCactusTest extends ServletTestCase {
	private ActionServlet servlet;

	public SearchActionCactusTest(String theName) {
		super(theName);
	}

	public void setUp() throws Exception {
		servlet = new ActionServlet();
		servlet.init(config);
	}

	public void beginSuccess(WebRequest request) {
		request.setURL(null, // server name (e.g. 'localhost:8080')
									 null, // context (e.g. '/MiniHR20')
									 "/search.do", // servlet path 
									 null,         // extra path info
									 "name=Jim");    // query string
	}

	public void testSuccess() throws Exception {
		servlet.doGet(request, response);
		SearchForm form = (SearchForm) request.getAttribute("searchForm");
		assertNotNull(form.getResults());
	}

	public void tearDown() throws Exception {
		servlet.destroy();
	}
}
