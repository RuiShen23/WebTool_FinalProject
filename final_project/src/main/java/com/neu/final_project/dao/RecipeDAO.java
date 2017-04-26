package com.neu.final_project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.beans.factory.support.ReplaceOverride;

import com.neu.final_project.pojo.Recipe;
import com.neu.final_project.pojo.User;

public class RecipeDAO extends DAO {

	// create new recipe
	public String addRecipe(Recipe recipe) {
		String status = "error";

		try {
			begin();
			getSession().save(recipe);
			commit();
			status = "success";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			rollback();
		} finally {
			close();
		}
		return status;
	}

	//get recipe by category
	public List<Recipe> getRecipeCategory(String category){
		try {
			begin();		
			Query q = getSession().createQuery("from Recipe where category = :category");			
			q.setParameter("category", category);
			List<Recipe> recipeList = q.list();			
			commit();
			
			return recipeList;
		} finally {
			close();
		}
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
	
	//get a random recipe by category and calorie
	public Recipe getRecipeForMeal(String category, int calPerMeal) {
		try {
			begin();
			Query query = getSession().createQuery("from Recipe where category = :category");
			query.setParameter("category", category);
			List<Recipe> recipeList = query.list();

			List<Recipe> rl = new ArrayList<Recipe>();
			for (Recipe recipe : recipeList) {
				int recipeCal = (int)recipe.getTotalCalorie();
				if (recipeCal-100<calPerMeal && calPerMeal<recipeCal+100){
					rl.add(recipe);
				}				
			}
			int rid = (int) (rl.size()*Math.random());
			Recipe recipe = rl.get(rid);
			commit();
			return recipe;
		} finally {
			close();
		}
	}
	
	// display all recipes
	public List<Recipe> showAllRecipe() {

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

	// get saved recipes of a user
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
	public List<Recipe> getRegisteredUserRecipes(User user) {
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
		

}
