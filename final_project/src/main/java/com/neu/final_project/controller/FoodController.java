package com.neu.final_project.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.final_project.dao.FoodDAO;
import com.neu.final_project.dao.UserDAO;
import com.neu.final_project.pojo.Food;
import com.neu.final_project.pojo.User;

@Controller
public class FoodController {
	
	static final String TEMP_FORDER = "/Users/Rui/Documents/GitHub/WebTool_FinalProject/final_project/src/main/webapp/image/";
	 
	@Autowired
	@Qualifier("foodDAO")
	FoodDAO foodDAO;
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;

	//user show unwanted food
	@RequestMapping(value="/user/user-unwanted-food/view", method=RequestMethod.GET)
	public ModelAndView showUserUnwantedFood(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		User user = (User)request.getSession().getAttribute("user");
		List<Food> foodList = (List<Food>) user.getUnwantedFood();
		
		modelAndView.addObject("foodList", foodList);
		modelAndView.setViewName("user/UserUnwantedFood");
			
		return modelAndView;
	}
	
	//user remove unwanted food
	@RequestMapping(value="/user/user-unwanted-food/remove", method=RequestMethod.POST)
	public String removeUserUnwantedFood(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		String unwantedFoodId = request.getParameter("unwantedFoodId");
		
		for (int i=0;i<user.getUnwantedFood().size();i++){
			if(user.getUnwantedFood().get(i).getFoodId()==Integer.parseInt(unwantedFoodId)){
				user.getUnwantedFood().remove(i);
			}
		}

		userDAO.updateUser(user);
		return "redirect:/user/user-unwanted-food/view";
	}
	
	
	//pns show all food
	@RequestMapping(value="/employee/pns-manage-food", method=RequestMethod.GET)
	public ModelAndView showAllFood(){
		ModelAndView modelAndView = new ModelAndView();
				
		List<Food> foodList = foodDAO.showAllFood();
			
		modelAndView.addObject("foodList", foodList);
		modelAndView.setViewName("employee/PnsManageFood");
		return modelAndView;
	}
	
	//pns add food
	@RequestMapping(value="/employee/pns-manage-food/add", method=RequestMethod.POST)
	public String addFood(Food food, HttpServletRequest request) throws IOException{

		CommonsMultipartFile photo = food.getPhoto();   

        String fileName = photo.getOriginalFilename();
        String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
        
        String path = TEMP_FORDER + trueFileName;
        photo.transferTo(new File(path));
        
        food.setPhotoPath(trueFileName);
		
		String status = foodDAO.addFood(food);
		if(status.equals("failed")){
			request.setAttribute("errorMessage", "Error occurred when adding new food");
			return "employee/PnsManageFood";
		}else
			return "redirect:/employee/pns-manage-food";
	}	
	
	//pns modify food
	@RequestMapping(value="/employee/pns-manage-food/modify", method=RequestMethod.POST)
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
			
		return "redirect:/employee/pns-manage-food";
	}
	
	//show admin manage food price page
	@RequestMapping(value = "employee/admin-manage-food", method=RequestMethod.GET)
	public String showManagePricePage(HttpServletRequest request){		
		List<Food> foodList = foodDAO.searchNoPriceFood();
		request.setAttribute("foodList", foodList);
		return "/employee/AdminManageFoodPrice";
	}
	
	//redirect below post page
	@RequestMapping(value = "employee/admin-manage-food/updatePrice", method=RequestMethod.GET)
	public String redirectAdminUpdatePricePage(){
		return "/employee/AdminManageFoodPrice";
	}
	
	//admin update food price
	@RequestMapping(value = "employee/admin-manage-food/updatePrice", method=RequestMethod.POST)
	public String adminUpdatePrice(HttpServletRequest request){	
		
		String[] foodId = (String[]) request.getParameterValues("foodId");
		String[] price = (String[]) request.getParameterValues("price");

		for(int i=0;i<foodId.length;i++){
			int id = Integer.parseInt(foodId[i]);
			float p = Float.parseFloat(price[i]);
			foodDAO.updateFoodPrice(id, p);
		}
		
		return "redirect:/employee/admin-manage-food";
	}
	
}
