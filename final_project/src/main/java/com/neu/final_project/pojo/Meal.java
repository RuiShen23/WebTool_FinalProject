package com.neu.final_project.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="meal")
public class Meal {
	
	private int mealId;
	private Set<MealItem> mealItems; //m-m, one way
	private String category; //breakfast, lunch, dinner, sneak
	private String cookingInstruction;	
	// no need to be save to db, use formula property to calculate values
	// corresponding columns available in mealItem table
	private float totalCalorie;
	private float totalFat;
	private float totalCarb;
	private float totalProtein;
	
	
	public Meal(){
		
	}
	
	public Meal(Set<MealItem> mealItems, String category, String cookingInstruction) {
		this.mealItems = mealItems;
		this.category = category;
		this.cookingInstruction = cookingInstruction;
	}

	@Id
	@Column(name="meal_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getMealId() {
		return mealId;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="meal_mealItem", joinColumns=@JoinColumn(name="meal_id"), inverseJoinColumns=@JoinColumn(name="mealItem_id"))
	public Set<MealItem> getMealItems() {
		return mealItems;
	}
	
	@Column(name="category")
	public String getCategory() {
		return category;
	}
	
	@Column(name="cooking_instr")
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
	
	
	public void setMealId(int mealId) {
		this.mealId = mealId;
	}
	public void setMealItems(Set<MealItem> mealItems) {
		this.mealItems = mealItems;
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
