package com.neu.final_project.dao;

import org.hibernate.Query;
import org.springframework.web.util.HtmlUtils;

import com.neu.final_project.pojo.Employee;
import com.neu.final_project.pojo.User;

public class EmployeeDAO extends DAO{
	
		//create new pns
		public String createPns(Employee employee){
			String status = "failed";
			
			try {
				begin();
				
				getSession().save(employee);
				status = "success";
				
				commit();
				return status;
			} finally {
				close();
			}
		}
		
		//employee login
		public Employee getEmployee(String username, String password){			
			try {
				begin();
				
				String hql;
				hql = "from Employee where username = :username and password = :password";
				Query q = getSession().createQuery(hql);							
				q.setParameter("username", HtmlUtils.htmlUnescape(username));
				q.setParameter("password", HtmlUtils.htmlUnescape(password));
				
				Employee employee = (Employee) q.uniqueResult();
				commit();
				return employee;
			} finally {
				close();
			}
		}
		
}
