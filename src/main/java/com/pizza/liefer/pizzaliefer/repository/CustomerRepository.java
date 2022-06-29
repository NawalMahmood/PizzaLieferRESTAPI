package com.pizza.liefer.pizzaliefer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizza.liefer.pizzaliefer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByName(String name);

	List<Customer> findByNameAndAddress(String name, String address);

	// SELECT * FROM table WHERE name LIKE %keyword%
	List<Customer> findByNameContaining(String keyword);

}
