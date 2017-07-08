package com.nathansmenu.menu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

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
	@OrderBy("menuItem")
	private MealTime mealTime;
	
	@ManyToMany
	private Set<Tag> tags;
	
	public Set<Tag> getTags(){
		return tags;
	}

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
	
	public MenuItem(String mealName, MealTime mealTime, String ingredients, String description, Tag... tag) {
		this.mealName = mealName;
		this.mealTime = mealTime;
		this.ingredients = ingredients;
		this.description = description;
		this.tags = new HashSet<>(Arrays.asList(tag));
	}
		
	@Override
	public String toString() {
		return mealName + mealTime + ingredients + description + tags;
	}

	public MenuItem() {

	}
	
	
	
}
