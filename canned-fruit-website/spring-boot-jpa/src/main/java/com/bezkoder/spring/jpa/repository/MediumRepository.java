package com.bezkoder.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.model.Medium;

public interface MediumRepository extends JpaRepository<Medium, Long> {
  List<Medium> findByMediumName(String mediumName);
  
  //Medium findById(int id);

  List<Medium> findByMediumNameContainingIgnoreCase(String mediumNameFragment);
  
}
