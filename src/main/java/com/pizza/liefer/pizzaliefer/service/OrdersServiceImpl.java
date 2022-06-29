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

		// Order status updated with 20s delay to simulate the delay between receiving
		// and dispatching an order
		Thread thread = new Thread() {
			public void run() {
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					throw new RuntimeException(
							"Unfortunately, we cannot process your order at this moment. Please  try again later.");
				}
				order.setStatus("Dispatched");
				orderRepo.save(order);

				Transaction transaction = new Transaction();
				transaction.setOrderId(order.getId());
				transaction.setTransAmount(calculateTransAmount(order));
				transRepo.save(transaction);
			}
		};
		thread.start();
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

		CustomerOrder oldOrder = getOrder(id);
		if (oldOrder.getStatus().equalsIgnoreCase("Dispatched")) {
			throw new RuntimeException("Order has been dispatched, and can no longer be canceled.");
		}

		// Delete transactions associated with order first
		List<Transaction> transactions = transRepo.findByOrderId(id);
		for (Transaction trans : transactions) {
			transRepo.deleteById(trans.getId());
		}

		orderRepo.deleteById(id);
	}

	@Override
	public void updateOrder(CustomerOrder order) {

		CustomerOrder oldOrder = getOrder(order.getId());
		if (oldOrder.getStatus().equalsIgnoreCase("Dispatched")) {
			throw new RuntimeException("Order has been dispatched, and can no longer be modified.");
		}

		orderRepo.save(order);
	}

	private Double calculateTransAmount(CustomerOrder order) {

		Double price = 10.0; // Each pizza costs 10 euro, irrespective of number of toppings
		return price;
	}
}
