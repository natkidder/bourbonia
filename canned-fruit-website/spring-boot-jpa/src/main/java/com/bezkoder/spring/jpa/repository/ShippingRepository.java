package com.bezkoder.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.model.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
  List<Shipping> findByType(String Type);
  
  //Shipping findById(int id);

  List<Shipping> findByTypeContainingIgnoreCase(String typeFragment);
 
}
