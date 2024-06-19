package com.jamesholmes.minihr;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

public class SearchForm extends ValidatorForm
{
  private String name = null;
  private String ssNum = null;
  private List results = null;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setSsNum(String ssNum) {
    this.ssNum = ssNum;
  }

  public String getSsNum() {
    return ssNum;
  }

  public void setResults(List results) {
    this.results = results;
  }

  public List getResults() {
    return results;
  }
}
