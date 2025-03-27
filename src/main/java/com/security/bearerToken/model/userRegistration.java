package com.security.bearerToken.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_REGISTRATON")
public class userRegistration {

	private String id;
	@Id
	private String userId;
	private String name;
	private String email;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public userRegistration(String id, String userId, String name, String email, String password) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public userRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", userId=" + userId + ", name=" + name + ", email=" + email + ", password="
				+ password + "]";
	}

}
