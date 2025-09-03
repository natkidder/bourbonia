package com.bezkoder.spring.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bezkoder.spring.jpa.model.Customer;
import com.bezkoder.spring.jpa.model.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
  
  //Customer findById(int id);
	
  //List<Customer> findByBusinessNameContainingIgnoreCase(String businessName);
  
  //List<Customer> findByBusinessNameAndOutletName(String businessName, String outletName);
  
  //@Query("SELECT c FROM Customer c WHERE c.businessName LIKE :businessName AND c.outletName LIKE :outletName")
  //List<Customer> findByCustomQuery(@Param("businessName") String businessName, @Param("outletName") String outletName);
 
  //List<Customer> findByBusinessNameIgnoreCaseContaining(String BusinessName);

  List<CustomerOrder> findByCardNbr(String cardNbr);
  List<CustomerOrder> findByCustomerPocEmail(String email);
}
