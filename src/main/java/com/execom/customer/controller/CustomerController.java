package com.execom.customer.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.execom.customer.model.*;
import com.execom.customer.service.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomers() {
		return new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
		return new ResponseEntity<>(customerService.findOne(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Customer> removeCustomer(@PathVariable("id") Long id) {
		if(isExistCustomer(id)) {
			Customer customer = customerService.findOne(id);
			customerService.remove(id);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") Long id) {
		if (isExistCustomer(id)) {
			customerService.save(customer);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}

	private boolean isExistCustomer(Long id) {
		boolean result = false;
		if(customerService.findOne(id) != null)
			result = true;
		return result;
	}

	// methods of controller get post put delete
	// post is add
	// put is edit customer => findById != null editujemo ga posto ima sta da se edituje else -> http not found
}
