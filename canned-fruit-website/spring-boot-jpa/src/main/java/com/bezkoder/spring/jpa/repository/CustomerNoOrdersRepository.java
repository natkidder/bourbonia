package com.bezkoder.spring.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bezkoder.spring.jpa.model.CustomerNoOrders;

public interface CustomerNoOrdersRepository extends JpaRepository<CustomerNoOrders, Long> {
  // TODO implement the below
	//List<Customer> findByName(String first, String Last);
  
  //Customer findById(int id);
	
  List<CustomerNoOrders> findByBusinessNameContainingIgnoreCase(String businessName);
  
  List<CustomerNoOrders> findByBusinessNameAndOutletName(String businessName, String outletName);
  
  //@Query("SELECT c FROM Customer_No_Orders c WHERE c.businessName LIKE :businessName AND c.outletName LIKE :outletName")
  //List<CustomerNoOrders> findByCustomQuery(@Param("businessName") String businessName, @Param("outletName") String outletName);
 
  List<CustomerNoOrders> findByBusinessNameIgnoreCaseContaining(String BusinessName);

  Optional<CustomerNoOrders> findByPocEmail(String pocEmail);
}
