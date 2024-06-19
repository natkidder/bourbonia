package com.jamesholmes.minihr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeSearchService
{
  /* Hard-coded sample data. Normally this would come from a real data
     source such as a database. */
  private static List employees;
  static 
  {
  	employees = new ArrayList();
    employees.add(new Employee("Bob Davidson", "123-45-6789"));
		employees.add(new Employee("Mary Williams", "987-65-4321"));
		employees.add(new Employee("Jim Smith", "111-11-1111"));
		employees.add(new Employee("Beverly Harris", "222-22-2222"));
		employees.add(new Employee("Thomas Frank", "333-33-3333"));
		employees.add(new Employee("Jim Davidson", "444-44-4444"));
  }

  // Search for employees by name.
  public ArrayList searchByName(String name) {
    ArrayList resultList = new ArrayList();

    for (Iterator k = employees.iterator(); k.hasNext();) {
    	Employee employee = (Employee) k.next();
      if (employee.getName().toUpperCase().indexOf(name.toUpperCase()) != -1) {
        resultList.add(employee);
      }
    }

    return resultList;
  }

  // Search for employee by social security number.
  public ArrayList searchBySsNum(String ssNum) {
    ArrayList resultList = new ArrayList();

		for (Iterator k = employees.iterator(); k.hasNext();) {
			Employee employee = (Employee) k.next();
			if (employee.getSsNum().equals(ssNum)) {
				resultList.add(employee);
			}
    }

    return resultList;
  }
  
  static void addEmployee(String name, String ssNum) {
  	employees.add(new Employee(name, ssNum));
  }
}