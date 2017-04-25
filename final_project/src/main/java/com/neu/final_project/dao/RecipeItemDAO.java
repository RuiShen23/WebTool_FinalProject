package com.neu.final_project.dao;

import com.neu.final_project.pojo.RecipeItem;

public class RecipeItemDAO extends DAO {

	// create new recipe item
	public String addRecipeItem(RecipeItem recipeItem) {
		String status = "error";
		try {
			begin();
			getSession().save(recipeItem);
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
}
