package com.execom.customer.service;

import java.util.*;

import com.execom.customer.model.*;

public interface CustomerService {

	Customer findOne(Long id);
	List<Customer> findAllCustomers();
	Customer save(Customer customer);
	void remove(Long id);
}
