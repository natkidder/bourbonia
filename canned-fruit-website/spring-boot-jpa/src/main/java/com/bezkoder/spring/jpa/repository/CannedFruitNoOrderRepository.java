package com.bezkoder.spring.jpa.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.model.Customer;
import com.bezkoder.spring.jpa.model.CannedFruit;
import com.bezkoder.spring.jpa.model.CannedFruitNoOrders;

public interface CannedFruitNoOrderRepository extends JpaRepository<CannedFruitNoOrders, Long> {
  //List<CannedFruit> findByType(String Type);
  
  //CannedFruit findById(int id);

  //List<CannedFruit> findByTypeContainingIgnoreCase(String typeFragment);
  List<CannedFruitNoOrders> findByFruitContainingIgnoreCase(String fruitFragment);
  List<CannedFruitNoOrders> findAll();  // could also be a hibernate collection
 
}
