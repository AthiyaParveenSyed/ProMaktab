package com.uuq.model;

import jakarta.persistence.*;

@Entity // This tells Spring Boot to create a table for this model in MySQL
@Table(name = "users") // Table name in MySQL
public class User {
	@Id // Marks this as the Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
	private Long id;
	private String name;
	private String whatsappNumber;
	private String password;

	public User() {
	}

	public User(String name, String whatsappNumber, String password) {
		this.name = name;
		this.whatsappNumber = whatsappNumber;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWhatsappNumber() {
		return whatsappNumber;
	}

	public void setWhatsappNumber(String whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
