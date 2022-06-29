package com.pizza.liefer.pizzaliefer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResponse {

	@JsonProperty("Order_Number")
	private Long orderNum;
	@JsonProperty("Message")
	private String orderMsg;

	public OrderResponse(Long orderNum, String orderMsg) {
		this.orderNum = orderNum;
		this.orderMsg = orderMsg;
	}

}
