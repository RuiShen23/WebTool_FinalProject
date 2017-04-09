package com.neu.final_project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="account")
@Inheritance(strategy=InheritanceType.JOINED)
public class Account {
	
	private int id;
	private String username;
	private String password;
	private String email;
	private String accountType = "registered";
	
	public Account(){
		
	}
		
	public Account(String username, String password, String email, String accountType) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.accountType = accountType;
	}


	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	
	@Column(name="account_type")
	public String getAccountType() {
		return accountType;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
}
