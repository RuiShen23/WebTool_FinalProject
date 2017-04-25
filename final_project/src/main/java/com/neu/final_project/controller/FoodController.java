package com.neu.final_project.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.final_project.dao.FoodDAO;
import com.neu.final_project.pojo.Food;
import com.neu.final_project.pojo.User;

@Controller
public class FoodController {
	
	@Autowired
	@Qualifier("foodDAO")
	FoodDAO foodDAO;

	
	@RequestMapping(value="/food/view/user-unwanted-food", method=RequestMethod.GET)
	public ModelAndView showUserUnwantedFood(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		User user = (User)request.getSession().getAttribute("user");
		Set<Food> foodList = (Set<Food>) user.getUnwantedFood();
		
		modelAndView.addObject("foodList", foodList);
		modelAndView.setViewName("user/UserUnwantedFood");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/food/add/user-unwanted-food", method=RequestMethod.GET)
	public void addUserUnwantedFood(){
		
	}
	
	//pns show all food
	@RequestMapping(value="/food/pns-manage", method=RequestMethod.GET)
	public ModelAndView showAllFood(){
		ModelAndView modelAndView = new ModelAndView();
				
		List<Food> foodList = foodDAO.showAllFood();
			
		modelAndView.addObject("foodList", foodList);
		modelAndView.setViewName("employee/PnsManageFood");
		return modelAndView;
	}
	
	//pns add food
	@RequestMapping(value="/food/pns-manage/add", method=RequestMethod.POST)
	public String addFood(@ModelAttribute("Food")Food food){
				
		String status = foodDAO.addFood(food);
			
		return "redirect:/food/pns-manage";
	}	
	
	//pns modify food
	@RequestMapping(value="/food/pns-manage/modify", method=RequestMethod.POST)
	public String addFood(HttpServletRequest request){
		
		String[] foodId = (String[]) request.getParameterValues("foodId");
		String[] calories = (String[]) request.getParameterValues("calories");
		String[] carb = (String[]) request.getParameterValues("carb");
		String[] fat = (String[]) request.getParameterValues("fat");
		String[] protein = (String[]) request.getParameterValues("protein");
		String[] names = (String[]) request.getParameterValues("names");

		for(int i=0;i<foodId.length;i++){
			int id = Integer.parseInt(foodId[i]);
			float cal = Float.parseFloat(calories[i]);
			float c = Float.parseFloat(carb[i]);
			float f = Float.parseFloat(fat[i]);
			float p = Float.parseFloat(protein[i]);
			
			foodDAO.updateFoodNutrition(id, cal, c, f, p, names[i]);
		}
			
		return "redirect:/food/pns-manage";
	}
	
	//show admin manage food price page
	@RequestMapping(value = "food/admin-manage", method=RequestMethod.GET)
	public String showManagePricePage(HttpServletRequest request){		
		List<Food> foodList = foodDAO.searchNoPriceFood();
		request.setAttribute("foodList", foodList);
		return "/employee/AdminManageFoodPrice";
	}
	
	//admin update food price
	@RequestMapping(value = "food/admin-manage/updatePrice", method=RequestMethod.POST)
	public String adminUpdatePrice(HttpServletRequest request){	
		
		String[] foodId = (String[]) request.getParameterValues("foodId");
		String[] price = (String[]) request.getParameterValues("price");

		for(int i=0;i<foodId.length;i++){
			int id = Integer.parseInt(foodId[i]);
			float p = Float.parseFloat(price[i]);
			foodDAO.updateFoodPrice(id, p);
		}
		
		return "redirect:/food/admin-manage";
	}
	
}
