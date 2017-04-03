package com.JNIT.springapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.JNIT.springapp.entity.Customer;
import com.JNIT.springapp.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need injection for the customer DAO
	@Autowired
	// private CustomerDAO customerDAO;
	private CustomerService customerservice;

	// @RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// Get the customers to the DAO
		List<Customer> theCustomer = customerservice.getCustomers();

		// Add the customers to the model
		theModel.addAttribute("customers", theCustomer);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// Create model Attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		customerservice.saveCustomer(theCustomer);
		return "redirect:/customer/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// Get the customer from the service
		Customer theCustomer = customerservice.getCustomerDetails(theId);
		// Set the customer details witht he model attribute.
		theModel.addAttribute("customer", theCustomer);

		// Send it to the form
		return "customer-form";

	}
	
	@GetMapping("/delete")
	public String showFormForDelete(@RequestParam("customerId") int theId) {

		// Get the customer from the service
		customerservice.deleteCustomerDetails(theId);
		
		

		// Send it to the form
		return "redirect:/customer/list";

	}
	
	
	

}
