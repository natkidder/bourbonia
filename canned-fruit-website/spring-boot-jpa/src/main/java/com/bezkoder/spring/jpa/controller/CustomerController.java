package com.bezkoder.spring.jpa.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jpa.model.CannedFruit;
import com.bezkoder.spring.jpa.model.Customer;
import com.bezkoder.spring.jpa.model.CustomerNoOrders;
import com.bezkoder.spring.jpa.model.Fruit;
import com.bezkoder.spring.jpa.repository.CustomerNoOrdersRepository;
import com.bezkoder.spring.jpa.repository.CustomerRepository;

// origins was http://localhost:8081
@CrossOrigin(origins = "http://localhost:8081", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("/api2")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerNoOrdersRepository customerNoOrdersRepository;

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam Map<String,String> params) {
		try {
			List<Customer> customers = new ArrayList<Customer>();
			List<Customer> filteredCustomers = new ArrayList<Customer>();
;			String businessName = params.get("businessName");
			String outletName = params.get("outletName").toLowerCase();
			String pocFirst = params.get("pocFirst").toLowerCase();
			String pocLast = params.get("pocLast").toLowerCase();
			System.out.println("businessName='"+businessName+"'    outletName='"+outletName+"'    pocFirst='"+pocFirst+"'    pocLast='"+pocLast+"'"); ///////
			//customerRepository.findByBusinessNameAndOutletName(businessName, outletName).forEach(customers::add);
			Comparator<Customer> compareByOutlet = Comparator.comparing(Customer::getBusinessName).thenComparing(Customer::getOutletName);
			customerRepository.findByBusinessNameIgnoreCaseContaining(businessName).forEach(customers::add);
			filteredCustomers = customers.stream()
					.filter(customer -> customer.getOutletName().toLowerCase().contains(outletName))
					.filter(customer -> customer.getPocFirst().toLowerCase().contains(pocFirst))
					.filter(customer -> customer.getPocLast().toLowerCase().contains(pocLast))
					.sorted(compareByOutlet)
					.collect(Collectors.toList());

			if (customers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			//CustomerCollection customerCollection = new CustomerCollection(customers);
			return new ResponseEntity<>(filteredCustomers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/* Get all customers fitting the business/outlet/POC filters that have no outstanding orders */
	@GetMapping("/customerNoOrders")
	public ResponseEntity<List<CustomerNoOrders>> getAllNoOrderCustomers(@RequestParam Map<String,String> params) {
		try {
			List<CustomerNoOrders> customers = new ArrayList<CustomerNoOrders>();
			List<CustomerNoOrders> filteredCustomers = new ArrayList<CustomerNoOrders>();
;			String businessName = params.get("businessName");
			String outletName = params.get("outletName").toLowerCase();
			String pocFirst = params.get("pocFirst").toLowerCase();
			String pocLast = params.get("pocLast").toLowerCase();
			System.out.println("businessName='"+businessName+"'    outletName='"+outletName+"'    pocFirst='"+pocFirst+"'    pocLast='"+pocLast+"'"); ///////
			//customerRepository.findByBusinessNameAndOutletName(businessName, outletName).forEach(customers::add);
			//Comparator<CustomerNoOrders> compareByOutlet = Comparator.comparing(CustomerNoOrders::getBusinessName).thenComparing(CustomerNoOrders::getOutletName);
			customerNoOrdersRepository.findByBusinessNameIgnoreCaseContaining(businessName).forEach(customers::add);
			filteredCustomers = customers.stream()
					.filter(customer -> customer.getOutletName().toLowerCase().contains(outletName))
					.filter(customer -> customer.getPocFirst().toLowerCase().contains(pocFirst))
					.filter(customer -> customer.getPocLast().toLowerCase().contains(pocLast))
					.collect(Collectors.toList());

			if (customers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			//CustomerCollection customerCollection = new CustomerCollection(customers);
			return new ResponseEntity<>(filteredCustomers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/customerIdCollection")
	public ResponseEntity<List<Customer>> getCustomerByIds(@RequestParam(value = "id") List<Long> ids) {
        System.out.println("trying to run "+this.getClass().getCanonicalName()+".getCustomerByIds"); /////////
		try {
			List<Customer> customers = new ArrayList<Customer>();
			customerRepository.findByIdIn(ids).forEach(customers::add);
			//Customer customerData = customerRepository.findById(id).get();
			if (customers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
		Optional<Customer> customerData = customerRepository.findById(id);
		//Customer customerData = customerRepository.findById(id).get();
		System.out.println("getCustomerById 00:"+(customerData == null)); ///////
		System.out.println("getCustomerById 05:"+customerData.toString()); ///////

		if (customerData.isPresent()) {
			return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/customer/pocEmail/{pocEmail}")
	public ResponseEntity<Customer> getCustomerByPocEmail(@PathVariable("pocEmail") String pocEmail) {
		Optional<Customer> customerData = customerRepository.findByPocEmail(pocEmail);
		//Customer customerData = customerRepository.findById(id).get();
		System.out.println("getCustomerByPocEmail 00:"+(customerData == null)); ///////
		System.out.println("getCustomerByPocEmail 05:"+customerData.toString()); ///////

		if (customerData.isPresent()) {
			return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		System.out.println("running "+this.getClass().getCanonicalName()+" createCustomer"); ///////
		try {
			Customer _customer = customerRepository.save(new Customer(customer.getId(), customer.getBusinessName(), customer.getOutletName(), customer.getPocFirst(), 
					customer.getPocLast(), customer.getPocPhone(), customer.getPocEmail(), customer.getAddresses()));
			System.out.println(_customer.toString()); ////////
			return new ResponseEntity<>(_customer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		Optional<Customer> customerData = customerRepository.findById(id);

		if (customerData.isPresent()) {
			Customer _customer = customerData.get();
			_customer.setBusinessName(customer.getBusinessName());
			_customer.setOutletName(customer.getOutletName());
			_customer.setPocFirst(customer.getPocFirst());
			_customer.setPocLast(customer.getPocLast());
			_customer.setPocEmail(customer.getPocEmail());
			_customer.setPocPhone(customer.getPocPhone());
			_customer.setAddresses(customer.getAddresses());
			return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
		try {
			customerRepository.deleteById(id);
			System.out.println("Tried to delete ID "+id); /////////
			//TODO see how you can determine if the customer was actually deleted
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/customer")
	public ResponseEntity<HttpStatus> deleteAllCustomers() {
		try {
			customerRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
