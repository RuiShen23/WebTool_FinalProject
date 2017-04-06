package com.neu.final_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	//redirect to register page
	@RequestMapping(value="/register", method=RequestMethod.GET) 
	public void showRegisterPage(){
		
	}
	
	//process register request
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void registerUser(){
		
	}
	
	//redirect to login page
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void showLoginPage(){
		
	}
	
	//process user login
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void loginUser(){
		
	}
	
	//redirect to upgrade page
	@RequestMapping(value="/upgrade-premier-user", method=RequestMethod.GET)
	public void showUpgradePage(){
		
	}
	
	//process upgrade request
	@RequestMapping(value="/upgrade-premier-user", method=RequestMethod.POST)
	public void upgradeUser(){
		
	}
	
}