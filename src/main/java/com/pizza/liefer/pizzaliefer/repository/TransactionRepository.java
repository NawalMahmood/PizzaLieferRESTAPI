package com.pizza.liefer.pizzaliefer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizza.liefer.pizzaliefer.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByOrderId(Long id);

	List<Transaction> findByTransAmount(Float amount);

}
