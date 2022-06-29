package com.pizza.liefer.pizzaliefer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pizza.liefer.pizzaliefer.model.Customer;
import com.pizza.liefer.pizzaliefer.model.CustomerOrder;
import com.pizza.liefer.pizzaliefer.model.OrderResponse;
import com.pizza.liefer.pizzaliefer.model.RegistrationResponse;
import com.pizza.liefer.pizzaliefer.service.CustomerService;
import com.pizza.liefer.pizzaliefer.service.OrdersService;

@RestController
public class CustomerOrdersController {

	// Response messages returned to clients
	private static String CUSTOMER_CREATED = "Your registration was successful!";
	private static String ORDER_PLACED = "Your order was placed successfully!";
	private static String ORDER_UPDATED = "Your order was updated successfully!";
	private static String ORDER_DELETED = "Your order was deleted successfully!";

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
	public ResponseEntity<CustomerOrder> getOrder(@PathVariable("id") Long id) {

		return new ResponseEntity<CustomerOrder>(ordersService.getOrder(id), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<RegistrationResponse> saveCustomer(@Valid @RequestBody Customer customer) {

		custService.saveCustomer(customer);
		RegistrationResponse response = new RegistrationResponse(customer.getId(), CUSTOMER_CREATED);

		return new ResponseEntity<RegistrationResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/order")
	public ResponseEntity<OrderResponse> placeOrder(HttpServletRequest request) throws IOException {

		CustomerOrder order = deserializeRequest(request);
		ordersService.saveOrder(order);

		OrderResponse response = new OrderResponse(order.getId(), ORDER_PLACED);
		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/order/{id}")
	public ResponseEntity<OrderResponse> updateOrder(@PathVariable("id") Long id,
			@Valid @RequestBody CustomerOrder order) {

		ordersService.updateOrder(order);
		OrderResponse response = new OrderResponse(order.getId(), ORDER_UPDATED);

		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<OrderResponse> deleteOrder(@PathVariable("id") Long id) {

		ordersService.deleteOrder(id);
		OrderResponse response = new OrderResponse(id, ORDER_DELETED);

		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}

	private CustomerOrder deserializeRequest(HttpServletRequest request) throws IOException {

		// Reads the request body and returns it as a string
		String requestBody = IOUtils.toString(request.getReader());
		ObjectMapper mapper = new ObjectMapper();
		// Uses Jackson to convert JSON in request body to CustomerOrder object
		CustomerOrder order = mapper.readValue(requestBody, CustomerOrder.class);

		return order;
	}
}
