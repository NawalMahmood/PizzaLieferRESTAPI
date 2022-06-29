package com.pizza.liefer.pizzaliefer.service;

import java.util.List;

import com.pizza.liefer.pizzaliefer.model.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(Long id);

	void deleteCustomer(Long id);

	void updateCustomer(Customer customer);

	List<Customer> getCustomersByName(String name);

	List<Customer> getCustomersByNameAndAddress(String name, String address);

	List<Customer> getCustomersByKeyword(String keyword);

}
