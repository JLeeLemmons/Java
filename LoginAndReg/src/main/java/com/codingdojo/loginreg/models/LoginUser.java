package com.codingdojo.loginreg.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
	
	@NotEmpty(message="You need an email")
    @Email(message="Email better silly!")
    private String email;
    
    @NotEmpty(message="You cannot leave the password empty")
    @Size(min=8, max=128, message="Password must be atleast 8 characters")
    private String password;
    
    public LoginUser() {
    	
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
    
    

}
