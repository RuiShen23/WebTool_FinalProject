package com.neu.final_project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neu.final_project.dao.FoodDAO;
import com.neu.final_project.dao.RecipeDAO;
import com.neu.final_project.dao.RecipeItemDAO;
import com.neu.final_project.pojo.Food;
import com.neu.final_project.pojo.Recipe;
import com.neu.final_project.pojo.User;


@Controller
public class RecipeController {
	
	
	@Autowired
	@Qualifier("recipeDAO")
	RecipeDAO recipeDAO;
	
	@Autowired
	@Qualifier("foodDAO")
	FoodDAO foodDAO;
	
	@Autowired
	@Qualifier("recipeItemDAO")
	RecipeItemDAO recipeItemDAO;
	
	//ajax - generate daily menu
	@RequestMapping(value="/recipe/daily/generate", method=RequestMethod.POST)
	@ResponseBody
	public List<Recipe> generateDailyRecipe(HttpServletRequest request){
		
		int calories = Integer.parseInt(request.getParameter("caloriesNumber"));
		String mealNum = request.getParameter("mealNumber");
		List<Recipe> recipeList = new ArrayList<Recipe>();
		
		if (mealNum.equals("2meals")){
			int calPerMeal  = calories/2;

			Recipe lunchRecipe = recipeDAO.getRecipeForMeal("lunch", calPerMeal);
			Recipe dinnerRecipe = recipeDAO.getRecipeForMeal("dinner", calPerMeal);
			recipeList.add(lunchRecipe);
			recipeList.add(dinnerRecipe);	
		}else if (mealNum.equals("3meals")) {
			int calPerMeal  = calories/3;
			
			Recipe breakfastRecipe = recipeDAO.getRecipeForMeal("breakfast", calPerMeal);
			Recipe lunchRecipe = recipeDAO.getRecipeForMeal("lunch", calPerMeal);
			Recipe dinnerRecipe = recipeDAO.getRecipeForMeal("dinner", calPerMeal);
			
			recipeList.add(breakfastRecipe);
			recipeList.add(lunchRecipe);
			recipeList.add(dinnerRecipe);
		}else {
			int calPerMeal  = calories/4;
			
			Recipe breakfastRecipe = recipeDAO.getRecipeForMeal("breakfast", calPerMeal);
			Recipe lunchRecipe = recipeDAO.getRecipeForMeal("lunch", calPerMeal);
			Recipe sneakRecipe = recipeDAO.getRecipeForMeal("sneak", calPerMeal);
			Recipe dinnerRecipe = recipeDAO.getRecipeForMeal("dinner", calPerMeal);
			
			recipeList.add(breakfastRecipe);
			recipeList.add(lunchRecipe);
			recipeList.add(sneakRecipe);
			recipeList.add(dinnerRecipe);
		}
		
		return recipeList;
	}
	
	//user view saved-recipe
	@RequestMapping(value="/recipe/user-saved-recipe/view", method=RequestMethod.GET)
	public ModelAndView showUserUnwantedFood(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		User user = (User)request.getSession().getAttribute("user");
		Set<Recipe> recipeList = (Set<Recipe>) user.getSavedRecipe();
		
		modelAndView.addObject("recipeList", recipeList);
		modelAndView.setViewName("user/UserSavedRecipe");
		
		return modelAndView;
	}
	
	//redirect to PnsManageRcipe page
	@RequestMapping(value="/recipe/pns-manage")
	public String showPnsManageRecipePage(HttpServletRequest request){
		request.setAttribute("allFoodList", foodDAO.showAllFood());
		return "employee/PnsManageRecipe";
	}
	
	//ajax - pns view recipes by category
	@RequestMapping(value="/recipe/pns-manage/view-by-category", method=RequestMethod.GET)
	@ResponseBody
	public List<Recipe> showRecipeByCategory(HttpServletRequest request){			
		String recipeCategory = request.getParameter("recipeCategory");
		List<Recipe> recipeList = recipeDAO.getRecipeCategory(recipeCategory);
		request.setAttribute("recipeList", recipeList);
		 
		return recipeList;
	}
	
	//process pns create new recipe request
	@RequestMapping(value="/recipe/pns-manage/create", method=RequestMethod.POST)
	public void pnsCreateRecipe(Recipe recipe, HttpServletRequest request){

		String[] foodIds = request.getParameterValues("foodIds");
					
		int count = 0;
		for (String id: foodIds){	
			if (id.equals("none")){
				recipe.getRecipeItems().remove(count);
				continue;
			}
			Food food = foodDAO.getFood(Integer.parseInt(id));
			recipe.getRecipeItems().get(count).setFood(food);
			recipe.getRecipeItems().get(count).setRecipe(recipe);
			count += 1;
		}	
		
		recipeDAO.addRecipe(recipe);
		
	}
	
	@RequestMapping(value="/recipe/pns-manage/modify", method=RequestMethod.GET)
	public void pnsUpdateRecipe(){
		
	}
	
	
}
