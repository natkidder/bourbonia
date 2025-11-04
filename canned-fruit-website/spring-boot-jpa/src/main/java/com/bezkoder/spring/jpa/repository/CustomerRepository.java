package com.bezkoder.spring.jpa.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bezkoder.spring.jpa.model.CannedFruit;
import com.bezkoder.spring.jpa.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  // TODO implement the below
	//List<Customer> findByName(String first, String Last);
  
  //Customer findById(int id);

  List<Customer> findByIdIn(Collection<Long> ids);  // could also be a hibernate collection

  List<Customer> findByBusinessNameContainingIgnoreCase(String businessName);
  
  List<Customer> findByBusinessNameAndOutletName(String businessName, String outletName);
  
  @Query("SELECT c FROM Customer c WHERE c.businessName LIKE :businessName AND c.outletName LIKE :outletName")
  List<Customer> findByCustomQuery(@Param("businessName") String businessName, @Param("outletName") String outletName);
 
  List<Customer> findByBusinessNameIgnoreCaseContaining(String BusinessName);

  Optional<Customer> findByPocEmail(String pocEmail);
}
