package com.pizza.liefer.pizzaliefer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.liefer.pizzaliefer.model.Customer;
import com.pizza.liefer.pizzaliefer.model.Order;
import com.pizza.liefer.pizzaliefer.service.CustomerService;
import com.pizza.liefer.pizzaliefer.service.OrdersService;

@RestController
public class CustomerOrdersController {

	private static String CUSTOMER_CREATED = "Your registration was successful!";
	private static String ORDER_PLACED = "Your order was placed successfully!";
	private static String ORDER_UPDATED = "Your order was updated successfully!";

	@Autowired
	private CustomerService custService;

	@Autowired
	private OrdersService ordersService;

	@Value("${app.name}")
	private String appName;

	@Value("${app.version}")
	private String appVersion;

	@GetMapping("/version")
	public String getAppDetails() {
		return appName + " - " + appVersion;
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable("id") Long id) {

		return new ResponseEntity<Order>(ordersService.getOrder(id), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<String> saveCustomer(@Valid @RequestBody Customer customer) {

		custService.saveCustomer(customer);
		return new ResponseEntity<String>(CUSTOMER_CREATED, HttpStatus.CREATED);
	}

	@PostMapping("/order")
	public ResponseEntity<String> placeOrder(@Valid @RequestBody Order order) {

		ordersService.saveOrder(order);
		return new ResponseEntity<String>(ORDER_PLACED, HttpStatus.CREATED);
	}

	@PutMapping("/order/{id}")
	public ResponseEntity<String> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {

		ordersService.updateOrder(order);
		return new ResponseEntity<String>(ORDER_UPDATED, HttpStatus.OK);
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<HttpStatus> deleteOrder(@RequestParam("id") Long id) {

		ordersService.deleteOrder(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
