package com.neu.final_project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="recipeItem")
public class RecipeItem {

	private int recipeItemId;
	private int quantity;
	private Food food; //one-way, m-1
	private Recipe recipe; //two-way, m-1
	//these are calculated values
	private float calories;
	private float fat;
	private float carb;
	private float protein;	
	private float price;
	
	public RecipeItem(){
		
	}
		
	public RecipeItem(int quantity, Food food) {
		this.quantity = quantity;
		this.food = food;
	}

	@Id
	@Column(name="RECIPE_ITEM_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getRecipeItemId() {
		return recipeItemId;
	}
	
	@Column(name="QUANTITY")
	public int getQuantity() {
		return quantity;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FOOD_ID", nullable = false)
	public Food getFood() {
		return food;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RECIPE_ID", nullable = false)
	public Recipe getRecipe() {
		return recipe;
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
	public void setRecipeItemId(int recipeItemId) {
		this.recipeItemId = recipeItemId;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
}