package com.neu.final_project.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.web.util.HtmlUtils;

import com.neu.final_project.pojo.Account;
import com.neu.final_project.pojo.User;


public class UserDAO extends DAO{

	//create new user
	public String createUser(User user){
		String status = "failed";
		
		try {
			begin();
			
			getSession().save(user);
			status = "success";
			
			commit();
			return status;
		} finally {
			close();
		}
	}
	
	//user login
	public User getUser(String loginName, String password){
		String status = "failed"; 
		
		try {
			begin();
			
			String hql;
			if (loginName.contains("@"))
				hql = "from Account where email = :loginName and password = :password";
			else
				hql = "from Account where username = :loginName and password = :password";
						
			Query q = getSession().createQuery(hql);
						
			q.setParameter("loginName", HtmlUtils.htmlUnescape(loginName));
			q.setParameter("password", HtmlUtils.htmlUnescape(password));
			
			User user = (User) q.uniqueResult();
			
			commit();
			return user;
		} finally {
			close();
		}
	}
	
}
