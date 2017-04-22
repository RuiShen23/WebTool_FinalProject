package com.neu.final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import com.neu.final_project.dao.UserDAO;
import com.neu.final_project.pojo.User;
import com.neu.final_project.validator.UserRegisterValidator;

@Controller
public class UserController {

	@Autowired
	@Qualifier("user")
	User user;
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("accountRegisterValidator")
	UserRegisterValidator userRegisterValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userRegisterValidator);
	}
	
	//redirect to register page
	@RequestMapping(value="/user/register", method=RequestMethod.GET) 
	public void showRegisterPage(){
		
	}
	
	//process register request
	@RequestMapping(value="/user/register", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") User user, BindingResult result){
		userRegisterValidator.validate(user, result);
		
		user.setUsername(HtmlUtils.htmlUnescape(user.getUsername()));
		user.setEmail(HtmlUtils.htmlEscape(user.getEmail()));
		user.setPassword(HtmlUtils.htmlEscape(user.getPassword()));
		if (result.hasErrors())
			return new ModelAndView("UserRegister","account",user);	
		
		String status = userDAO.createUser(user);
		return new ModelAndView(status);				
	}
	
	//redirect to login page
	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public void showLoginPage(){
		
	}
	
	//process user login
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public void loginUser(@RequestParam("loginName") String loginName, @RequestParam("password") String password){
		User user = userDAO.getUser(loginName, password);
		user.getAccountType();
	}
	
	//user log out
	@RequestMapping(value="/user/logout", method=RequestMethod.GET)
	public void logOutUser(){
		
	}
	
	//redirect to upgrade page
	@RequestMapping(value="/user/upgrade-premier-user", method=RequestMethod.GET)
	public void showUpgradePage(){
		
	}
	
	//process upgrade request
	@RequestMapping(value="/user/upgrade-premier-user", method=RequestMethod.POST)
	public void upgradeUser(){
		
	}
	
}
