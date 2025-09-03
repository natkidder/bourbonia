package com.bezkoder.spring.jpa.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bezkoder.spring.jpa.model.CannedFruit;
import com.bezkoder.spring.jpa.model.Fruit;

public interface CannedFruitRepository extends JpaRepository<CannedFruit, Long> {
  List<CannedFruit> findByFruit(String fruit);
  
  //CannedFruit findById(int id);

  List<CannedFruit> findByFruitContainingIgnoreCase(String fruitFragment);
  List<CannedFruit> findByIdIn(Collection<Long> ids);  // could also be a hibernate collection
  
  @Query(value="select cf.fruit from canned_fruit cf group by cf.fruit order by cf.fruit", nativeQuery=true)
  List<String> findFruits();
 
}
