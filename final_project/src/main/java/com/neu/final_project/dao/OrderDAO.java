package com.neu.final_project.dao;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.List;

import org.hibernate.Query;

import com.neu.final_project.pojo.Order;
import com.neu.final_project.pojo.User;

public class OrderDAO extends DAO{

	//create order
	public void createOrder(Order order){
		try {
			begin();
			
			getSession().save(order);

			commit();
			
		} finally {
			close();
		}
	}
	
	//display all orders a user placed
	//also need to get order items and set to orders
	public List<Order> showUserOrder(User user){
		try {
			begin();
			
			int id = user.getId();
			String hql = "from Order where user := id";
			Query query = getSession().createQuery(hql);
			query.setInteger("id", id);
			
			List<Order> orderList = query.list();
			commit();
			return orderList;
		} finally {
			close();
		}
	}
	
	
}
