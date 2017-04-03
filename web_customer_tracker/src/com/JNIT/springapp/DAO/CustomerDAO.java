package com.JNIT.springapp.DAO;

import java.util.List;

import com.JNIT.springapp.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomerDetails(int theId);

	public void deleteCustomerDetails(int theId);

}
