package com.execom.customer.repository;

import org.springframework.data.jpa.repository.*;

import com.execom.customer.model.*;

//@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findById(Long id);

}
