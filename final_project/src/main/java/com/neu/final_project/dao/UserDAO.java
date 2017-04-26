package com.neu.final_project.dao;

import org.hibernate.Query;
import org.springframework.web.util.HtmlUtils;

import com.neu.final_project.pojo.Employee;
import com.neu.final_project.pojo.User;


public class UserDAO extends DAO{

	//create new user
	public String createUser(User user){		
		try {
			String status ="failed";
			begin();			
			getSession().save(user);
			status="success";
			commit();
			return status;
		} catch (Exception e) {
			return "failed";
		}finally {
			close();
		}
	}
	
	//get user by id
	public User getUser(int id){
		try {
			begin();
			Query query = getSession().createQuery("from User where id = :id");
			query.setParameter("id", id);
			User user = (User) query.uniqueResult();
			commit();
			return user;
		} finally {
			close();
		}
	}
	
	//user login
	public User loginUser(String loginName, String password){
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
	
	//delete user
	public void deleteUser(User user){
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			rollback();
		}finally {
			close();
		}
	}
	
	//update user
	public void updateUser(User user){
		try {
			begin();
			getSession().update(user);
			commit();
		} finally {
			close();
		}
	}
	
}
