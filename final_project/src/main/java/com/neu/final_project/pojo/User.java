package com.neu.final_project.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User extends Account{
	
	private int userId;
	private Set<Food> unwantedFood; //m-m, one way
	private Set<Meal> savedMeal; //m-m, one way
	
	public User(){
		
	}	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<Food> getUnwantedFood() {
		return unwantedFood;
	}

	public void setUnwantedFood(Set<Food> unwantedFood) {
		this.unwantedFood = unwantedFood;
	}

	public Set<Meal> getSavedMeal() {
		return savedMeal;
	}

	public void setSavedMeal(Set<Meal> savedMeal) {
		this.savedMeal = savedMeal;
	}
	
	


}
