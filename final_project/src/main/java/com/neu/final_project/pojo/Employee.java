package com.neu.final_project.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee_table")
public class Employee extends Account{

	private int employeeId;
	private String firstName;
	private String lastName;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
