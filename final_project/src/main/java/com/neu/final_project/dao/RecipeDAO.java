package com.neu.final_project.dao;

import java.util.List;

import org.hibernate.Query;

import com.neu.final_project.pojo.Recipe;
import com.neu.final_project.pojo.User;

public class RecipeDAO extends DAO {

	// create new recipe
	public String addRecipe(Recipe recipe) {
		String status = "Error occurred, please try again";

		try {
			begin();
			getSession().save(recipe);
			commit();
			status = "Recipe successfully added!";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			rollback();
		} finally {
			close();
		}
		return status;
	}

	//get recipe by id
	public Recipe getRecipe(int id){
		try {
			begin();
			String hql = "from Recipe where recipeId = :id";
			Query query = getSession().createQuery(hql);
			query.setParameter("id", id);
			Recipe recipe = (Recipe) query.uniqueResult();
			commit();
			return recipe;
		} finally {
			close();
		}
	}
	
	// display all recipes
	public List<Recipe> showAllMeal() {

		try {
			begin();

			String hql = "from Recipe";

			Query q = getSession().createQuery(hql);
			List<Recipe> recipeList = q.list();

			commit();

			return recipeList;
		} finally {
			close();
		}
	}

	// display saved recipes of a user
	public List<Recipe> searchSavedRecipe(User user) {

		try {
			begin();
			
			int userId = user.getId();

			String hql = "select savedRecipe from User where id = :userId";

			Query q = getSession().createQuery(hql);
			q.setParameter("userId", userId);
			List recipeList = q.list();

			commit();

			return recipeList;
		} finally {
			close();
		}
	}

	// get available recipes for registered users (with/without unwantedFood)
	public List getRegisteredUserRecipes(User user) {
		try {
			begin();

			int userId = user.getId();
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
