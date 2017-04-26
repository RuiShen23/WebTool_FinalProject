package com.neu.final_project.dao;

import org.hibernate.Query;
import org.springframework.web.util.HtmlUtils;

import com.neu.final_project.pojo.Employee;
import com.neu.final_project.pojo.User;

public class EmployeeDAO extends DAO{
	
		//create new pns
		public String createPns(Employee employee){			
			try {
				String status="failed";
				begin();			
				getSession().save(employee);
				commit();
				status="success";
				return status;
			} finally {
				close();
			}
		}
		
		//get employee by id
		public Employee getEmployee(int id){
			try {
				begin();
				Query query = getSession().createQuery("from Employee where id = :id");
				query.setParameter("id", id);
				Employee employee = (Employee) query.uniqueResult();
				commit();
				return employee;
			} finally {
				close();
			}
		}
		
		
		//employee login
		public Employee loginEmployee(String username, String password){			
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
		
		//delete employee
		public void deleteEmployee(Employee employee){
			try {
				begin();
				getSession().delete(employee);
				commit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				rollback();
			}finally {
				close();
			}
		}
		
		//update employee
		public void updateEmployee(Employee employee){
			try {
				begin();
				getSession().update(employee);
				commit();
			} finally {
				close();
			}
		}
		
}
