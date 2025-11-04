package com.bezkoder.spring.jpa.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.model.Customer;
import com.bezkoder.spring.jpa.model.Shipping;
import com.bezkoder.spring.jpa.model.ShippingNoOrders;

public interface ShippingNoOrderRepository extends JpaRepository<ShippingNoOrders, Long> {
  //List<Shipping> findByType(String Type);
  
  //Shipping findById(int id);

  //List<Shipping> findByTypeContainingIgnoreCase(String typeFragment);
  List<ShippingNoOrders> findAll();  // could also be a hibernate collection
 
}
