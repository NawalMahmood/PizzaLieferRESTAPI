package com.pizza.liefer.pizzaliefer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.liefer.pizzaliefer.model.CustomerOrder;
import com.pizza.liefer.pizzaliefer.model.Transaction;
import com.pizza.liefer.pizzaliefer.repository.OrderRepository;
import com.pizza.liefer.pizzaliefer.repository.TransactionRepository;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrderRepository orderRepo;
	@Autowired
	TransactionRepository transRepo;

	@Override
	public List<CustomerOrder> getOrders() {

		return orderRepo.findAll();
	}

	@Override
	public void saveOrder(CustomerOrder order) {

		order.setStatus("Being Prepared");
		orderRepo.save(order);
		try {
			// Simulates the time taken between receiving an order, and dispatching it
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(
					"Unfortunately, we cannot process your order at this moment. Please  try again later.");
		}

		order.setStatus("Dispatched");
		updateOrder(order);

		Transaction transaction = new Transaction();
		transaction.setOrderId(order.getId());
		transaction.setTransAmount(calculateTransAmount(order));
		transRepo.save(transaction);

	}

	@Override
	public CustomerOrder getOrder(Long id) {

		Optional<CustomerOrder> order = orderRepo.findById(id);
		if (order.isPresent()) {
			return order.get();
		}
		throw new RuntimeException("Order with id " + id + " not found.");
	}

	@Override
	public void deleteOrder(Long id) {

		// Delete transactions associated with order first
		List<Transaction> transactions = transRepo.findByOrderId(id);
		for (Transaction trans : transactions) {
			transRepo.deleteById(trans.getId());
		}

		orderRepo.deleteById(id);
	}

	@Override
	public void updateOrder(CustomerOrder order) {

		orderRepo.save(order);
	}

	private Double calculateTransAmount(CustomerOrder order) {

		Double price = 10.0; // Each pizza costs 10 euro, irrespective of number of toppings
		return price;

	}
}
