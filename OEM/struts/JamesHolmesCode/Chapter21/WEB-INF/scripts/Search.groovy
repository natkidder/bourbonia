import com.jamesholmes.minihr.EmployeeSearchService;


service = new EmployeeSearchService();

searchForm = struts.form;

// Perform employee search based on what criteria was entered.
name = searchForm.name;
if (name != null && name.trim().length() > 0) {
  results = service.searchByName(name);
} else {
  results = service.searchBySsNum(searchForm.ssNum.trim());
}

// Place search results in SearchForm for access by JSP.
searchForm.setResults(results);

// Forward control to this Action's input page.
struts.setForward(struts.mapping.inputForward);
