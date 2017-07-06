package com.nathansmenu.menu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class MenuItem {

	@Id
	@GeneratedValue
	private Long id;
	
	private String mealName;
	
	@Lob
	private String description;
	
	@Lob
	private String ingredients;
	
	@ManyToOne
	private MealTime mealtime;

	public Long getId() {
		return id;
	}
	
	public String getMealName() {
		return mealName;
	}

	public String getIngredients() {
		return ingredients;
	}
	
	public String getDescription() {
		return description;
	}
	
	public MenuItem(String mealName, MealTime mealtime, String ingredients, String description) {
		this.mealName = mealName;
		this.ingredients = ingredients;
		this.description = description;
	}
		
	@Override
	public String toString() {
		return mealName + description + ingredients + mealtime;
	}

	public MenuItem() {

	}
	
	
	
}
