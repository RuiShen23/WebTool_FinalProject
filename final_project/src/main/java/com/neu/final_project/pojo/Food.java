package com.neu.final_project.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_table")
public class Food {
	
	private int foodId;
	private String name;

	//basic unit for nutrition info and price is 1g
	private float calories;
	private float fat;
	private float carb;
	private float protein;
	
	private float price;
	
	private String foodCategory; //vegan and non-vegan

	public int getFoodId() {
		return foodId;
	}

	@Id
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCalories() {
		return calories;
	}

	public void setCalories(float calories) {
		this.calories = calories;
	}

	public float getFat() {
		return fat;
	}

	public void setFat(float fat) {
		this.fat = fat;
	}

	public float getCarb() {
		return carb;
	}

	public void setCarb(float carb) {
		this.carb = carb;
	}

	public float getProtein() {
		return protein;
	}

	public void setProtein(float protein) {
		this.protein = protein;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	
	 
	
}
