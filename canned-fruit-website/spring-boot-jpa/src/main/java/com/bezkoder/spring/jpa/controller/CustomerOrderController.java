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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jpa.model.CustomerOrder;
import com.bezkoder.spring.jpa.model.Fruit;
import com.bezkoder.spring.jpa.repository.CustomerOrderRepository;
import com.bezkoder.spring.jpa.repository.CustomerRepository;
import java.time.Instant;

@CrossOrigin(origins = "http://localhost:8081", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("/api2")
public class CustomerOrderController {

	@Autowired
	CustomerOrderRepository customerOrderRepository;

	@GetMapping("/customerOrder/{id}")
	public ResponseEntity<CustomerOrder> getCustomerOrderById(@PathVariable("id") long id) {
		Optional<CustomerOrder> customerOrderData = customerOrderRepository.findById(id);
		//CustomerOrder customerData = customerRepository.findById(id).get();
		System.out.println("getCustomerById 00:"+(customerOrderData == null)); ///////
		System.out.println("getCustomerById 05:"+customerOrderData.toString()); ///////

		if (customerOrderData.isPresent()) {
			return new ResponseEntity<>(customerOrderData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/customerOrder")
	public ResponseEntity<List<CustomerOrder>> getAllCustomerOrders(@RequestParam(required = false) String pocEmail) {
		try {
			List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
			if (pocEmail.isEmpty()) {
				customerOrderRepository.findAll().forEach(customerOrders::add);
			} else {
			    customerOrderRepository.findByCustomerPocEmail(pocEmail).forEach(customerOrders::add);
			}

			if (customerOrders.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			//CustomerOrderCollection customerOrderCollection = new CustomerOrderCollection(customerOrders);
			return new ResponseEntity<>(customerOrders, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ResponseBody
	@PostMapping("/customerOrder")
	public ResponseEntity<CustomerOrder> createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
		Instant currentInstant = Instant.now();
		System.out.println("running "+this.getClass().getCanonicalName()+" createCustomerOrder"); ///////
				System.out.println(currentInstant+": cannedFruit 01: " +customerOrder.getCustomerOrderItems().get(0).getCannedFruit().getId()); ////////
				//System.out.println(currentInstant+": cannedFruit 02: " +customerOrder.getCustomerOrderItems().get(1).getCannedFruit().getId()); ////////
		try {
			CustomerOrder _customerOrder = customerOrderRepository.save(new CustomerOrder(customerOrder.getId(), customerOrder.getCustomer(), 
					customerOrder.getNameOnCard(), customerOrder.getCardNbr(), customerOrder.getExpirationDt(), customerOrder.getCvv(), 
					customerOrder.getOrderStatus(), customerOrder.getCustomerOrderItems(), customerOrder.getShipping(), customerOrder.getShipToAddress()));
			System.out.println(currentInstant+" after customerOrderRepository.save: "+_customerOrder.toString()); ////////
			return new ResponseEntity<>(_customerOrder, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("==Exception Occurred: "+ e.getMessage()); //////
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/customerOrder/{id}")
	public ResponseEntity<CustomerOrder> updateCustomerOrder(@PathVariable("id") long id, @RequestBody CustomerOrder customerOrder) {
		Optional<CustomerOrder> customerData = customerOrderRepository.findById(id);

		if (customerData.isPresent()) {
			CustomerOrder _customerOrder = customerData.get();
			_customerOrder.setCustomer(customerOrder.getCustomer());
			_customerOrder.setNameOnCard(customerOrder.getNameOnCard());
			_customerOrder.setCardNbr(customerOrder.getCardNbr());
			_customerOrder.setExpirationDt(customerOrder.getExpirationDt());
			_customerOrder.setCvv(customerOrder.getCvv());
			_customerOrder.setCustomerOrderItems(customerOrder.getCustomerOrderItems());
			_customerOrder.setShipping(customerOrder.getShipping());
			_customerOrder.setShipToAddress(customerOrder.getShipToAddress());
			return new ResponseEntity<>(customerOrderRepository.save(_customerOrder), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/customerOrder/{id}")
	public ResponseEntity<HttpStatus> deleteCustomerOrder(@PathVariable("id") long id) {
		try {
			customerOrderRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/customerOrder")
	public ResponseEntity<HttpStatus> deleteAllCustomerOrders() {
		try {
			customerOrderRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
