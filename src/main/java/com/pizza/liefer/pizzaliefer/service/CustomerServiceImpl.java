package com.pizza.liefer.pizzaliefer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.liefer.pizzaliefer.model.Customer;
import com.pizza.liefer.pizzaliefer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repository;

	@Override
	public List<Customer> getCustomers() {

		return repository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {

		repository.save(customer);
	}

	@Override
	public Customer getCustomer(Long id) {

		Optional<Customer> cust = repository.findById(id);
		if (cust.isPresent()) {
			return cust.get();
		}
		throw new RuntimeException("Customer with id " + id + " not found.");
	}

	@Override
	public void deleteCustomer(Long id) {

		repository.deleteById(id);

	}

	@Override
	public void updateCustomer(Customer customer) {

		repository.save(customer);
	}

	@Override
	public List<Customer> getCustomersByName(String name) {

		return repository.findByName(name);
	}

	@Override
	public List<Customer> getCustomersByNameAndAddress(String name, String address) {

		return repository.findByNameAndAddress(name, address);
	}

	@Override
	public List<Customer> getCustomersByKeyword(String keyword) {

		return repository.findByNameContaining(keyword);
	}

}
