package com.neu.final_project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@PrimaryKeyJoinColumn(name="EMPLOYEE_ID")
public class Employee extends Account{

	private String firstName;
	private String lastName;
	
	public Employee() {
		
	}
	
	@Column(name="FIRST_NAME", nullable=false)
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="LAST_NAME", nullable=false)
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}	
	
}
