package com.execom.customer.model;

import javax.persistence.*;

@Entity
//@Data
public class Customer {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String lastname;

	public Customer() {}

	public Customer(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.lastname = customer.getLastname();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


}
