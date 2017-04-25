package com.neu.final_project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.final_project.pojo.Employee;

public class EmployeeRegisterValidator implements Validator {

	private static final String usernameRegEx = "^[\\w]+$";
	private static final String nameRegex = "^[a-zA-Z, .']+$";
	
	
	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Employee.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		Employee employee = (Employee) obj;
		
		// check empty/whitespace
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid username", "Username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid password", "Password is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid email", "Email is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid firstName", "First name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid lastName", "Last name is required");

		if (errors.hasErrors())
			return;

		// check regex
		boolean usernameMatch = employee.getUsername().matches(usernameRegEx);
		boolean firstnameMatch = employee.getFirstName().matches(nameRegex);
		boolean lastnameMatch = employee.getLastName().matches(nameRegex);
		
		if(usernameMatch == false)
			errors.rejectValue("username", "error.invalid username", "Username should only contain letters, numbers and underscore('_') ");
		if(firstnameMatch == false)
			errors.rejectValue("firstName", "error.invalid firstName", "Please enter a valid first name");
		if(lastnameMatch == false)
			errors.rejectValue("lastName", "error.invalid lastName", "Please enter a valid last name");
	}

}
