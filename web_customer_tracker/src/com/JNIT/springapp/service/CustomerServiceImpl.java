package com.JNIT.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JNIT.springapp.DAO.CustomerDAO;
import com.JNIT.springapp.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// We need to inject the Customer DAO

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomer();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomerDetails(int theId) {
	
		return customerDAO.getCustomerDetails( theId);
	}

	@Override
	@Transactional
	public void deleteCustomerDetails(int theId) {
		
		customerDAO.deleteCustomerDetails(theId);
	}



}
