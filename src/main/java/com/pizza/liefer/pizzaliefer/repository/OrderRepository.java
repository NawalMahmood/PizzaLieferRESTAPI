package com.pizza.liefer.pizzaliefer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizza.liefer.pizzaliefer.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
