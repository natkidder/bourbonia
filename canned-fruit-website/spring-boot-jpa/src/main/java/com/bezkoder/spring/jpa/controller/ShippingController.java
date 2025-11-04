package com.bezkoder.spring.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jpa.model.Shipping;
import com.bezkoder.spring.jpa.model.ShippingCollection;
import com.bezkoder.spring.jpa.model.ShippingNoOrders;
import com.bezkoder.spring.jpa.repository.ShippingNoOrderRepository;
import com.bezkoder.spring.jpa.repository.ShippingRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api2")
public class ShippingController {

  @Autowired
  ShippingRepository shippingRepository;

  @Autowired
  ShippingNoOrderRepository shippingNoOrderRepository;

  @GetMapping(value="/shipping", produces="application/json")
  public ResponseEntity<List<Shipping>> getAllShippings(@RequestParam(required = false) String type) {
    try {
      List<Shipping> shippings = new ArrayList<Shipping>();

      if (type == null)
        shippingRepository.findAll(Sort.by(Sort.Direction.DESC, "price")).forEach(shippings::add);
      else
        shippingRepository.findByTypeContainingIgnoreCase(type).forEach(shippings::add);

      if (shippings.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      System.out.println("getAllShippings: "+shippings.size()); ///////
      return new ResponseEntity<>(shippings, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(value="/shippingNoOrders", produces="application/json")
  public ResponseEntity<List<ShippingNoOrders>> getAllShippingNoOrders() {
    try {
      List<ShippingNoOrders> shippingNoOrders = new ArrayList<ShippingNoOrders>();

      shippingNoOrderRepository.findAll().forEach(shippingNoOrders::add);

      if (shippingNoOrders.isEmpty()) {
    	System.out.println(this.getClass().getCanonicalName()+".getAllShippingNoOrders: found nothing");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      System.out.println("getAllShippingNoOrders: "+shippingNoOrders.size()); ///////
      return new ResponseEntity<>(shippingNoOrders, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

	@GetMapping("/shippingIdCollection")
	public ResponseEntity<List<Shipping>> getShippingByIds(@RequestParam(value = "id") List<Long> ids) {
      System.out.println("trying to run "+this.getClass().getCanonicalName()+".getShippingByIds"); /////////
		try {
			List<Shipping> shippings = new ArrayList<Shipping>();
			shippingRepository.findByIdIn(ids).forEach(shippings::add);
			//Shipping customerData = shippingRepository.findById(id).get();
			if (shippings.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(shippings, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

  @GetMapping(value="/shipping/{id}", produces="application/json")
  public ResponseEntity<Shipping> getShippingById(@PathVariable("id") long id) {
    Optional<Shipping> shippingData = shippingRepository.findById(id);

    if (shippingData.isPresent()) {
      return new ResponseEntity<>(shippingData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping(value="/shipping", consumes="application/json")
  public ResponseEntity<Shipping> createShipping(@RequestBody Shipping shipping) {
    try {
      Shipping _shipping = shippingRepository.save(new Shipping(shipping.getType(), shipping.getPrice()));
      return new ResponseEntity<>(_shipping, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/shipping/{id}")
  public ResponseEntity<Shipping> updateShipping(@PathVariable("id") long id, @RequestBody Shipping shipping) {
    Optional<Shipping> shippingData = shippingRepository.findById(id);

    if (shippingData.isPresent()) {
      Shipping _shipping = shippingData.get();
      _shipping.setType(shipping.getType());
      _shipping.setPrice(shipping.getPrice());
      return new ResponseEntity<>(shippingRepository.save(_shipping), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/shipping/{id}")
  public ResponseEntity<HttpStatus> deleteShipping(@PathVariable("id") long id) {
    try {
      shippingRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/shipping")
  public ResponseEntity<HttpStatus> deleteAllShippings() {
    try {
      shippingRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}
