package com.neu.final_project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.final_project.pojo.User;

public class UserRegisterValidator implements Validator{

	private static final String usernameRegEx = "^[\\w]+$";
	
	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(User.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		User user = (User) obj;
		
		//check empty/whitespace
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid username","Username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid password", "Password is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid email", "Email is required");
		
		if (errors.hasErrors())
			return;
		
		//check regex		
		boolean usernameMatch = user.getUsername().matches(usernameRegEx);
		
		if(usernameMatch == false)
			errors.rejectValue("username", "error.invalid username", "Username should only contain letters, numbers and underscore('_') ");

	}

}
