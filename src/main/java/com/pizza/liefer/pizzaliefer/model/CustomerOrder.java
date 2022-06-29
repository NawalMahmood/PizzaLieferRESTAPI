package com.pizza.liefer.pizzaliefer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Orders")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerOrder {

	@Column(name = "Order_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonProperty("Customer_Id")
	@Column(name = "Customer_Id")
	private Long customerId;

	@JsonProperty("Address")
	@Column(name = "Delivery_Address")
	private String address;

	@JsonProperty("Status")
	@Column(name = "Status")
	private String status;

	@JsonProperty("Ananas")
	@Column(name = "Ananas")
	public boolean ananas = false;

	@JsonProperty("Broccoli")
	@Column(name = "Broccoli")
	public boolean broccoli = false;

	@JsonProperty("Champignons")
	@Column(name = "Champignons")
	public boolean champignons = false;

	@JsonProperty("Gorgonzola")
	@Column(name = "Gorgonzola")
	public boolean gorgonzola = false;

	@JsonProperty("Gyrosfleisch")
	@Column(name = "Gyrosfleisch")
	public boolean gyrosfleisch = false;

	@JsonProperty("Hackfleisch")
	@Column(name = "Hackfleisch")
	public boolean hackfleisch = false;

	@JsonProperty("Knoblauch")
	@Column(name = "Knoblauch")
	public boolean knoblauch = false;

	@JsonProperty("Mozzarella")
	@Column(name = "Mozzarella")
	public boolean mozzarella = false;

	@JsonProperty("Oliven")
	@Column(name = "Oliven")
	public boolean oliven = false;

	@JsonProperty("Pepperoni")
	@Column(name = "Pepperoni")
	public boolean pepperoni = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isAnanas() {
		return ananas;
	}

	public void setAnanas(boolean ananas) {
		this.ananas = ananas;
	}

	public boolean isBroccoli() {
		return broccoli;
	}

	public void setBroccoli(boolean broccoli) {
		this.broccoli = broccoli;
	}

	public boolean isChampignons() {
		return champignons;
	}

	public void setChampignons(boolean champignons) {
		this.champignons = champignons;
	}

	public boolean isGorgonzola() {
		return gorgonzola;
	}

	public void setGorgonzola(boolean gorgonzola) {
		this.gorgonzola = gorgonzola;
	}

	public boolean isGyrosfleisch() {
		return gyrosfleisch;
	}

	public void setGyrosfleisch(boolean gyrosfleisch) {
		this.gyrosfleisch = gyrosfleisch;
	}

	public boolean isHackfleisch() {
		return hackfleisch;
	}

	public void setHackfleisch(boolean hackfleisch) {
		this.hackfleisch = hackfleisch;
	}

	public boolean isKnoblauch() {
		return knoblauch;
	}

	public void setKnoblauch(boolean knoblauch) {
		this.knoblauch = knoblauch;
	}

	public boolean isMozzarella() {
		return mozzarella;
	}

	public void setMozzarella(boolean mozzarella) {
		this.mozzarella = mozzarella;
	}

	public boolean isOliven() {
		return oliven;
	}

	public void setOliven(boolean oliven) {
		this.oliven = oliven;
	}

	public boolean isPepperoni() {
		return pepperoni;
	}

	public void setPepperoni(boolean pepperoni) {
		this.pepperoni = pepperoni;
	}
}
