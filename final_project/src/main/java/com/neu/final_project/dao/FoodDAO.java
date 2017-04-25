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

	//find food by id
	public Food getFood(int id){
		try {
			begin();
			String sql="from Food where foodId = :id";
			Query query = getSession().createQuery(sql);
			query.setParameter("id", id);
			Food food = (Food) query.uniqueResult();
			commit();
			return food;
		} finally {
			close();
		}
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
			List<Food> foodList = q.list();

			commit();

			return foodList;
			
		} finally {
			close();
		}
	}
	
	//display all food with price 0
	public List<Food> searchNoPriceFood(){
		try {
			begin();
			String hql = "from Food where price=0";
			
			Query q = getSession().createQuery(hql);
			List<Food> foodList = q.list();

			commit();

			return foodList;
		} finally {
			close();
		}
	}
	
	//update food nutrition info
	public void updateFoodNutrition(int foodId, float calories, float carb, float fat, float protein, String name){
		try {
			begin();
			String hql="update Food set calories=:calories, carb=:carb, fat=:fat, protein=:protein, name=:name where foodId = :foodId";
			Query query = getSession().createQuery(hql);
			query.setParameter("calories", calories);
			query.setParameter("carb", carb);
			query.setParameter("fat", fat);
			query.setParameter("protein", protein);
			query.setParameter("name", name);
			query.setInteger("foodId", foodId);
			query.executeUpdate();
			
			commit();
		} finally {
			close();
		}
	}

	//admin update food price
	public void updateFoodPrice(int foodId, float price){
		try {
			begin();
			String hql="update Food set price = :price where foodId = :foodId";
			Query query = getSession().createQuery(hql);
			query.setParameter("price", price);
			query.setInteger("foodId", foodId);
			query.executeUpdate();
			
			commit();
		} finally {
			close();
		}
	}
}
