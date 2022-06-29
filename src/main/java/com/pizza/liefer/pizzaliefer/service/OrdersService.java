package com.pizza.liefer.pizzaliefer.service;

import java.util.List;

import com.pizza.liefer.pizzaliefer.model.CustomerOrder;

public interface OrdersService {

	List<CustomerOrder> getOrders();

	void saveOrder(CustomerOrder order);

	CustomerOrder getOrder(Long id);

	void deleteOrder(Long id);

	void updateOrder(CustomerOrder order);

}
