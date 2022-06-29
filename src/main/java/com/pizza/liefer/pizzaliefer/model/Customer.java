package com.pizza.liefer.pizzaliefer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.CreditCardNumber;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Customers")
public class Customer {

	@Column(name = "Customer_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("Full_Name")
	@Column(name = "Name")
	@NotBlank(message = "Name must not be null or blank")
	private String name;

	@JsonProperty("Address")
	@Column(name = "Address")
	private String address;

	@JsonProperty("Telephone")
	@Column(name = "Telephone")
	@Size(min = 5, max = 15)
	private String telephone;

	@JsonProperty("Email")
	@Column(name = "Email")
	@Email(message = "Email must be in a valid format")
	private String email;

	@CreationTimestamp
	@Column(name = "Customer_Since", nullable = false, updatable = false)
	private Date joinDate;

	@JsonProperty("Payment_Card_Number")
	@Column(name = "PaymentCard")
	@CreditCardNumber(ignoreNonDigitCharacters = true)
	private String creditCardNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
