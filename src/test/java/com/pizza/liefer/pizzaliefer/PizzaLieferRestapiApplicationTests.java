package com.pizza.liefer.pizzaliefer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.pizza.liefer.pizzaliefer.model.OrderResponse;
import com.pizza.liefer.pizzaliefer.model.RegistrationResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PizzaLieferRestapiApplicationTests {

	private static String CUSTOMER_CREATED = "Your registration was successful!";
	private static String ORDER_PLACED = "Your order was placed successfully!";

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void testCustomerRegistrationEndpoint() {

		ResponseEntity<RegistrationResponse> response = testRestTemplate.getForEntity("/register",
				RegistrationResponse.class);
		assertTrue(response.getStatusCodeValue() == 200);
		assertTrue(response.getBody().getRegistrationMsg().equalsIgnoreCase(CUSTOMER_CREATED));
	}

	@Test
	void testOrderPlacementEndpoint() {

		ResponseEntity<OrderResponse> response = testRestTemplate.getForEntity("/order", OrderResponse.class);
		assertTrue(response.getStatusCodeValue() == 200);
		assertTrue(response.getBody().getOrderMsg().equalsIgnoreCase(ORDER_PLACED));
	}
}
