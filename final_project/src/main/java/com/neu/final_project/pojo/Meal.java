package com.neu.final_project.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="meal_table")
public class Meal {
	
	private int mealId;
	private Set<MealItem> mealItems; //m-1, one way
	private String category; //breakfast, lunch, dinner, sneak
	private String cookingInstruction;
	
	// no need to be save to db, rather these are some calculated values
	private float totalCalorie;
	private float totalFat;
	private float totalCarb;
	private float totalProtein;
	
}
