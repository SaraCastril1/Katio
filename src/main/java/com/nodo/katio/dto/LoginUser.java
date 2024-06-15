package com.nodo.katio.dto;

public class LoginUser {
    
	private String email;
	private String passhash;

	public LoginUser() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasshash() {
		return this.passhash;
	}

	public void setPasshash(String passhash) {
		this.passhash = passhash;
	}
	
}