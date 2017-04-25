package com.neu.final_project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_table")
public class Food {
	
	private int foodId;
	private String name;
	//basic unit for nutrition info and price is 1 serving size
	private float calories;
	private float fat;
	private float carb;
	private float protein;	
	private float price;
	
	public Food() {

	}
	
	public Food(String name, float calories, float fat, float carb, float protein) {
		this.name = name;
		this.calories = calories;
		this.fat = fat;
		this.carb = carb;
		this.protein = protein;
	}


	@Id
	@Column(name="FOOD_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getFoodId() {
		return foodId;
	}
	
	@Column(name="NAME", unique=true, nullable=false)
	public String getName() {
		return name;
	}
	
	
	@Column(name="CALORIES", nullable=false)
	public float getCalories() {
		return calories;
	}
	
	@Column(name="FAT", nullable=false)
	public float getFat() {
		return fat;
	}
	
	@Column(name="CARB", nullable=false)
	public float getCarb() {
		return carb;
	}
	
	@Column(name="PROTEIN", nullable=false)
	public float getProtein() {
		return protein;
	}
	
	@Column(name="PRICE", nullable=true)
	public float getPrice() {
		return price;
	}
	
	
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public void setName(String name) {
		this.name = name;
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
