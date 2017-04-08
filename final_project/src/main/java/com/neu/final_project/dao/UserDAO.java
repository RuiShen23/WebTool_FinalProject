package com.neu.final_project.dao;

import com.neu.final_project.pojo.User;

public class UserDAO extends DAO{

	//create new user
	public String createUser(User user){
		String status = "Error occurred, please try again";
		
		try {
			begin();
						
			getSession().save(user);
			status = "User successfully created!";
			
			commit();
			return status;
		} finally {
			close();
		}
	}
	
	
}
