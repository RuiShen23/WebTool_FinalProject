package com.neu.final_project.dao;

import java.util.List;

import org.hibernate.Query;

import com.neu.final_project.pojo.Food;
import com.neu.final_project.pojo.User;

public class FoodDAO extends DAO {

	// add food
	public String addFood(Food food) {
		String status = "Error occurred, please try again";

		try {
			begin();
			getSession().save(food);
			commit();
			status = "Submission succeed! Food pending for admin review";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			rollback();
		} finally {
			close();
		}

		return status;
	}

	// display all food
	public List<Food> showAllFood() {

		try {
			begin();

			String hql = "from Food";

			Query q = getSession().createQuery(hql);
			List foodList = q.list();

			commit();

			return foodList;
		} finally {
			close();
		}

	}
	
	//display unwanted food of a user
	public List<Food> searchUnwantedFood(User user){
		
		try {
			begin();
			
			String hql = "select unwantedFood from User where id = :userId";
			
			Query q = getSession().createQuery(hql);
			List foodList = q.list();

			commit();

			return foodList;
			
		} finally {
			close();
		}
	}
	
	//update food nutrition info (Food food, User user) user.usertype==PNS 
	

	//update food price info (Food food, User user) user.usertype==admin
	
}
