package com.neu.final_project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.final_project.pojo.User;

public class UserRegisterValidator implements Validator{

	private static final String usernameRegEx = "^(([0-9Xx][- ]*){13}|([0-9Xx][- ]*){10})$";
	private static final String passwordRegEx = "";
	private static final String emailRegEx = "";
	
	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(User.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		User user = (User) obj;
		
		//check empty/whitespace
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid username","Username is required");
		
		if (errors.hasErrors())
			return;
		
		//check regex
		
		boolean usernameMatch = user.getUsername().matches(usernameRegEx);
		
	}

}
