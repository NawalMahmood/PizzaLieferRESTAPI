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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getRegistrationMsg() {
		return registrationMsg;
	}

	public void setRegistrationMsg(String registrationMsg) {
		this.registrationMsg = registrationMsg;
	}

}
