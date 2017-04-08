package com.neu.final_project.pojo;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="account_table")
@Inheritance(strategy=InheritanceType.JOINED)
public class Account {
	
	private String username;
	private String password;
	private String email;
	private String accountType = "Registered";
	
	public Account(){
		
	}
		
	public Account(String username, String password, String email, String accountType) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.accountType = accountType;
	}

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
