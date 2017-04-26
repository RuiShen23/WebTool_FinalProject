package com.neu.final_project.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
@PrimaryKeyJoinColumn(name="USER_ID")
public class User extends Account{
	
	private List<Food> unwantedFood; //m-m, one way
	private List<Recipe> savedRecipe; //m-m, one way
	
	public User(){
		unwantedFood = new ArrayList<Food>();
		savedRecipe = new ArrayList<Recipe>();
	}

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_unwantedFood", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="food_id"))
	public List<Food> getUnwantedFood() {
		return unwantedFood;
	}

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_savedMeal", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="meal_id"))
	public List<Recipe> getSavedRecipe() {
		return savedRecipe;
	}
	
	
	public void setUnwantedFood(List<Food> unwantedFood) {
		this.unwantedFood = unwantedFood;
	}
	public void setSavedRecipe(List<Recipe> savedRecipe) {
		this.savedRecipe = savedRecipe;
	}	




}
