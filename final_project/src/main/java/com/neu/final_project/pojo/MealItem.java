package com.neu.final_project.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="mealItem")
public class MealItem {

	private int mealItemId;
	private int quantity;
	private Food food; //two-way, m-1
	//these are calculated values
	private float calories;
	private float fat;
	private float carb;
	private float protein;	
	private float price;
	
	public MealItem(){
		
	}
		
	public MealItem(int quantity, Food food) {
		this.quantity = quantity;
		this.food = food;
	}

	@Id
	@Column(name="mealItem_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getMealItemId() {
		return mealItemId;
	}
	
	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	public Food getFood() {
		return food;
	}
	
	@Formula("") //select from food where food_id = this.food.id * quantity
	public float getCalories() {
		return calories;
	}

	public float getFat() {
		return fat;
	}

	public float getCarb() {
		return carb;
	}

	public float getProtein() {
		return protein;
	}

	public float getPrice() {
		return price;
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
	public void setMealItemId(int mealItemId) {
		this.mealItemId = mealItemId;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	
	
	
}
