package com.pizza.liefer.pizzaliefer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationResponse {

	@JsonProperty("Customer_Id")
	private Long customerId;
	@JsonProperty("Message")
	private String registrationMsg;

	public RegistrationResponse(Long customerId, String registrationMsg) {
		this.customerId = customerId;
		this.registrationMsg = registrationMsg;
	}

}
