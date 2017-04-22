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
	//below are calculated values
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
	
	@Formula("(select sum(ri.QUANTITY*f.CALORIES) FROM recipeItem ri join food_table f on ri.FOOD_ID=f.FOOD_ID where ri.RECIPE_ID=RECIPE_ID)") 
	public float getTotalCalorie() {
		return totalCalorie;
	}
	
	@Formula("(select sum(ri.QUANTITY*f.FAT) FROM recipeItem ri join food_table f on ri.FOOD_ID=f.FOOD_ID where ri.RECIPE_ID=RECIPE_ID)") 
	public float getTotalFat() {
		return totalFat;
	}
	
	@Formula("(select sum(ri.QUANTITY*f.CARB) FROM recipeItem ri join food_table f on ri.FOOD_ID=f.FOOD_ID where ri.RECIPE_ID=RECIPE_ID)") 
	public float getTotalCarb() {
		return totalCarb;
	}
	
	@Formula("(select sum(ri.QUANTITY*f.PROTEIN) FROM recipeItem ri join food_table f on ri.FOOD_ID=f.FOOD_ID where ri.RECIPE_ID=RECIPE_ID)") 	
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
