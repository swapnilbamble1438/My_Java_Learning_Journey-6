package com.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Logindata {
	
	@NotBlank(message = "Username cannot be empty!")
	@Size(min = 3,max = 12, message = "Username must be between 3 to 12 characters")
	private String username;
	
	// you can also use @Email instead of @Pattern it will do the same work
	@Pattern(regexp ="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid Email")
	private String email;
	
	@AssertTrue(message = "Must agree terms and conditions!")
	private boolean agreed;

	
	public Logindata() {
	
	}


	public Logindata(String username, String email, boolean agreed) {
		super();
		this.username = username;
		this.email = email;
		this.agreed = agreed;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isAgreed() {
		return agreed;
	}


	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}


	@Override
	public String toString() {
		return "Logindata [username=" + username + ", email=" + email + ", agreed=" + agreed + "]";
	}
	
	
	
	
	
	

}
