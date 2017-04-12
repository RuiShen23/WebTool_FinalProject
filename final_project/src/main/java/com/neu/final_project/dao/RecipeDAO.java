package com.neu.final_project.dao;

import java.util.List;

import org.hibernate.Query;

import com.neu.final_project.pojo.Recipe;
import com.neu.final_project.pojo.User;

public class RecipeDAO extends DAO {

	// create new recipe
	public String addMeal(Recipe meal) {
		String status = "Error occurred, please try again";

		try {
			begin();
			getSession().save(meal);
			commit();
			status = "Meal successfully added!";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			rollback();
		} finally {
			close();
		}
		return status;
	}

	// display all recipes
	public List<Recipe> showAllMeal() {

		try {
			begin();

			String hql = "from Meal";

			Query q = getSession().createQuery(hql);
			List mealList = q.list();

			commit();

			return mealList;
		} finally {
			close();
		}
	}

	// display saved recipes of a user
	public List searchSavedMeal(User user) {

		try {
			begin();
			
			//int userId = user.getUserId();

			// select * from Meal where meal_id == (select meal_id from User where user_id = userId)
			String hql = " ";

			Query q = getSession().createQuery(hql);
			List mealList = q.list();

			commit();

			return mealList;

		} finally {
			close();
		}
	}

	// get available recipes for registered users (with/without unwantedFood)
	public List getRegisteredUserMeals(User user) {
		try {
			begin();

			//int userId = user.getUserId();
			/*sql logic: 
			1. select distinct meal_id from MealItem where food_id in 
				(select distinct food_id from User where user_id==userId) --> returns all meals with unwantedFood
			2.  select * from Meal where meal_id not in 1_result
			 might be possible to combine them into one sql statment
			 */
			String hql = " ";

			Query q = getSession().createQuery(hql);
			List mealList = q.list();

			commit();

			return mealList;
		} finally {
			close();
		}
	}
		
	// get available recipes for guest user (with/without requirements)
	public List getGuestUserMeals(String requirement){
		
		try {
			begin();
			
			//1. join MealItem[meal_id, food_id] and Food[food_id, category] on food_id
			//2. select distinct meal_id from temp_table where category == requirement
			//3. select meal_id from Meal where id != result_1
			
			String hql="";
			
			Query q = getSession().createQuery(hql);
			List mealList = q.list();
			
			commit();
			return mealList;
		} finally {
			close();
		}
	}	
	 

}
