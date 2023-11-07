package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
public class Userr {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// user name should not be null or empty
	// user name should have at least 2 characters
	@NotEmpty
	@Size(min = 2, message = "user name should hava at least 2 characters")
	private String name;
	
	// email should be a valid email format
	// email should not be null or empty
	@NotEmpty
	@Email
	private String email;
	
	// password should not be null or empty
	// password should have atleast 8 characters
	@NotEmpty
	@Size(min = 8, message = "password should have atleast 8 characters")
	private String password;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Userr(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public Userr() {
		
	}
	
	
	

}
