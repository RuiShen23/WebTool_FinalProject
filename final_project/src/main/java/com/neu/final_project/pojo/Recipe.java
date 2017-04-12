package com.neu.final_project.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="recipe")
public class Recipe {
	
	private int recipeId;
	private Set<RecipeItem> recipeItems; 
	private String category; //breakfast, lunch, dinner, sneak
	private String cookingInstruction;	
	// no need to be save to db, use formula property to calculate values
	// corresponding columns available in mealItem table
	private float totalCalorie;
	private float totalFat;
	private float totalCarb;
	private float totalProtein;
	
	
	public Recipe() {
		recipeItems = new HashSet<RecipeItem>();
	}
	
	public Recipe(Set<RecipeItem> recipeItems, String category, String cookingInstruction) {
		this.recipeItems = recipeItems;
		this.category = category;
		this.cookingInstruction = cookingInstruction;
	}

	@Id
	@Column(name="RECIPE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getRecipeId() {
		return recipeId;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="recipe")
	public Set<RecipeItem> getRecipeItems() {
		return recipeItems;
	}
	
	@Column(name="CATEGORY")
	public String getCategory() {
		return category;
	}
	
	@Column(name="COOKING_INSTR")
	public String getCookingInstruction() {
		return cookingInstruction;
	}
	
	@Formula("...") //below will have similar formula as this one
	public float getTotalCalorie() {
		return totalCalorie;
	}
	
	
	public float getTotalFat() {
		return totalFat;
	}
	
	
	public float getTotalCarb() {
		return totalCarb;
	}
	
	
	public float getTotalProtein() {
		return totalProtein;
	}
	
	
	public void setMealId(int recipeId) {
		this.recipeId = recipeId;
	}
	public void setMealItems(Set<RecipeItem> recipeItems) {
		this.recipeItems = recipeItems;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setCookingInstruction(String cookingInstruction) {
		this.cookingInstruction = cookingInstruction;
	}
	public void setTotalCalorie(float totalCalorie) {
		this.totalCalorie = totalCalorie;
	}
	public void setTotalFat(float totalFat) {
		this.totalFat = totalFat;
	}
	public void setTotalCarb(float totalCarb) {
		this.totalCarb = totalCarb;
	}
	public void setTotalProtein(float totalProtein) {
		this.totalProtein = totalProtein;
	}
	
	
}
