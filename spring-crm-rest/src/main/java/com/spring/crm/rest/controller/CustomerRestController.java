package com.spring.crm.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crm.rest.entity.Customer;
import com.spring.crm.rest.error.CustomerNotFoundException;
import com.spring.crm.rest.service.CustomerService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	// mapping for GET/Customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {

		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {

		Customer customer = customerService.getCustomer(customerId);

		if (customer == null) {
			throw new CustomerNotFoundException("Customer id " + customerId + " not found. ");
		}
		return customer;
	}

	// mapping for POST/Customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {

		customer.setId(0);
		customerService.saveCustomer(customer);

		return customer;
	}

	// mapping for update (PUT) customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {

		customerService.saveCustomer(customer);

		return customer;
	}

	// mapping for DELETE/customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {

		// validate customer exists or not 
		Customer customer = customerService.getCustomer(customerId);

		if (customer == null) {
			throw new CustomerNotFoundException("Customer id " + customerId + " not found. ");
		}
		customerService.deleteCustomer(customerId);

		return "Deleted customer id - " + customerId;
	}

}
