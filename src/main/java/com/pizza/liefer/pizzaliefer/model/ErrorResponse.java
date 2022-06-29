package com.pizza.liefer.pizzaliefer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

	@JsonProperty("Message")
	private String registrationMsg;

	public ErrorResponse(String registrationMsg) {
		this.registrationMsg = registrationMsg;
	}
}
