package com.JNIT.springapp.service;

import java.util.List;

import com.JNIT.springapp.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomerDetails(int theId);

	public void deleteCustomerDetails(int theId);

	
}
