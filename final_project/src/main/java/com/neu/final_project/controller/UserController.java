package com.neu.final_project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import com.neu.final_project.dao.FoodDAO;
import com.neu.final_project.dao.RecipeDAO;
import com.neu.final_project.dao.UserDAO;
import com.neu.final_project.pojo.Food;
import com.neu.final_project.pojo.Recipe;
import com.neu.final_project.pojo.User;
import com.neu.final_project.validator.UserRegisterValidator;

@Controller
public class UserController {

	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("userRegisterValidator")
	UserRegisterValidator userRegisterValidator;
	
	@Autowired
	@Qualifier("recipeDAO")
	RecipeDAO recipeDAO;
	
	@Autowired
	@Qualifier("foodDAO")
	FoodDAO foodDAO;
	
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userRegisterValidator);
	}
	
	//redirect to register page
	@RequestMapping(value="/user/register", method=RequestMethod.GET) 
	public String showRegisterPage(){
		return "/user/UserRegister";
	}
	
	//process register request
	@RequestMapping(value="/user/register", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		userRegisterValidator.validate(user, result);
		
		user.setUsername(HtmlUtils.htmlUnescape(user.getUsername()));
		user.setEmail(HtmlUtils.htmlEscape(user.getEmail()));
		user.setPassword(HtmlUtils.htmlEscape(user.getPassword()));
		if (result.hasErrors())
			return new ModelAndView("/user/UserRegister","user",user);	
		
		String status = userDAO.createUser(user);
		
		if(status.equals("success")){
			modelAndView.setViewName("/user/UserHomeIndex");
			modelAndView.addObject("user",user);
		}else{
			modelAndView.addObject("errorMessage","Error occured, please try again");
			modelAndView.setViewName("/user/UserRegister");
		}
		request.getSession().setAttribute("user", user);
		return modelAndView;				
	}
	
	//redirect to login page
	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public String showLoginPage(HttpServletRequest request){
		if(request.getSession().getAttribute("user")!=null){
			return "/user/UserHomeIndex";
		}
		return "user/UserLogin";
	}
	
	//process user login
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("loginName") String loginName, @RequestParam("password") String password, HttpServletRequest request){
		User user = userDAO.loginUser(loginName, password);
				
		if(user==null){
			request.setAttribute("errorMessage", "User username/password pair not found");
			return "user/UserLogin";
		}else{
			request.getSession().setAttribute("user", user);
			return "user/UserHomeIndex";
		}
	}
	
	//calculate user nutrition
	@RequestMapping(value="user/nutrition-calculator", method=RequestMethod.POST, produces="text/plain")
	@ResponseBody
	public String nutritionCalculator(HttpServletRequest request){
		
		int feet = Integer.parseInt(request.getParameter("height_feet"));
		int inch = Integer.parseInt(request.getParameter("height_inches"));
		int weight = Integer.parseInt(request.getParameter("weight_pounds"));
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");

		int bmr = 0;
		if(gender.equals("female")){
			bmr = (int) (655 + (4.35*weight) + (4.7* (12*feet+inch)) - (4.7*age));
		}else{
			bmr = (int) (66 + (6.23*weight) + (12.7* (12*feet+inch)) - (6.8*age));
		}	
		
		return Integer.toString(bmr);
	}
	
	//user log out
	@RequestMapping(value="/user/logout", method=RequestMethod.GET)
	public String logoutUser(HttpServletRequest request){
		request.getSession().invalidate();
		return "/user/UserLogout";
	}
	
	//redirect to upgrade page
	@RequestMapping(value="/user/upgrade-premier-user", method=RequestMethod.GET)
	public void showUpgradePage(){
		
	}
	
	//process upgrade request
	@RequestMapping(value="/user/upgrade-premier-user", method=RequestMethod.POST)
	public void upgradeUser(){
		
	}
	
	//user save recipe and unwanted food
	@RequestMapping(value="/user/saved-recipe-unwanted-food/add", method=RequestMethod.POST)
	public String addUserRecipeAndFood(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		String[] favRecipes = request.getParameterValues("favRecipe");
		String[] unwantedFood = request.getParameterValues("unwantedFood");	

		int usrRecipeLen = user.getSavedRecipe().size();
		int usrFoodLen = user.getUnwantedFood().size();
		
		Integer[] userRecipeIds = new Integer[usrRecipeLen];
		Integer[] userFoodlIds = new Integer[usrFoodLen];
		
		for (int i=0; i<usrRecipeLen; i++){
			userRecipeIds[i]  = user.getSavedRecipe().get(i).getRecipeId();
		}		
		for (int i=0; i<usrFoodLen; i++){
			userFoodlIds[i]  = user.getUnwantedFood().get(i).getFoodId();
		}
		
		List<Integer> rList = Arrays.asList(userRecipeIds);
		List<Integer> fList = Arrays.asList(userFoodlIds);
				
		if(favRecipes!= null){
			for(String s : favRecipes){
				if (rList.contains(Integer.parseInt(s))==false){
					Recipe recipe = recipeDAO.getRecipe(Integer.parseInt(s));
					user.getSavedRecipe().add(recipe);
				}				
			}
		}
		
		if(unwantedFood!= null){
			for(String s : unwantedFood){
				if (fList.contains(Integer.parseInt(s))==false){
					Food food = foodDAO.getFood(Integer.parseInt(s));
					user.getUnwantedFood().add(food);
				}				
			}
		}
		
		userDAO.updateUser(user);
						
		return "redirect:/user/login";		
	}
	
	
}
