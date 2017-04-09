package com.neu.final_project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class Food {
	
	private int foodId;
	private String name;
	private String foodCategory; //vegan and non-vegan
	//basic unit for nutrition info and price is 1g
	private float calories;
	private float fat;
	private float carb;
	private float protein;	
	private float price;
	
	public Food() {

	}
	
	public Food(String name, String foodCategory, float calories, float fat, float carb, float protein) {
		this.name = name;
		this.foodCategory = foodCategory;
		this.calories = calories;
		this.fat = fat;
		this.carb = carb;
		this.protein = protein;
	}


	@Id
	@Column(name="food_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getFoodId() {
		return foodId;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	
	@Column(name="category")
	public String getFoodCategory() {
		return foodCategory;
	}
	
	@Column(name="calories")
	public float getCalories() {
		return calories;
	}
	
	@Column(name="fat")
	public float getFat() {
		return fat;
	}
	
	@Column(name="carb")
	public float getCarb() {
		return carb;
	}
	
	@Column(name="protein")
	public float getProtein() {
		return protein;
	}
	
	@Column(name="price")
	public float getPrice() {
		return price;
	}
	
	
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public void setCalories(float calories) {
		this.calories = calories;
	}
	public void setFat(float fat) {
		this.fat = fat;
	}
	public void setCarb(float carb) {
		this.carb = carb;
	}
	public void setProtein(float protein) {
		this.protein = protein;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	

}
