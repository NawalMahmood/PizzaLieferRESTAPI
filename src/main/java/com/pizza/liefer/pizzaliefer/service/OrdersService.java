package com.pizza.liefer.pizzaliefer.service;

import java.util.List;

import com.pizza.liefer.pizzaliefer.model.Order;

public interface OrdersService {

	List<Order> getOrders();

	void saveOrder(Order order);

	Order getOrder(Long id);

	void deleteOrder(Long id);

	void updateOrder(Order order);

	// List<Order> getOrdersByAddress(String address);

}
