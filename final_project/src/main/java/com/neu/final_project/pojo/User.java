package com.neu.final_project.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
@PrimaryKeyJoinColumn(name="USER_ID")
public class User extends Account{
	
	private Set<Food> unwantedFood; //m-m, one way
	private Set<Recipe> savedRecipe; //m-m, one way
	private Set<Order> orders; //1-m, two way
	
	public User(){
		
	}

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_unwantedFood", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="food_id"))
	public Set<Food> getUnwantedFood() {
		return unwantedFood;
	}

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_savedMeal", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="meal_id"))
	public Set<Recipe> getSavedRecipe() {
		return savedRecipe;
	}
	
	
	@OneToMany(mappedBy="user")	
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public void setUnwantedFood(Set<Food> unwantedFood) {
		this.unwantedFood = unwantedFood;
	}
	public void setSavedRecipe(Set<Recipe> savedRecipe) {
		this.savedRecipe = savedRecipe;
	}	




}
