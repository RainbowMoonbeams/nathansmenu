package com.nathansmenu.menu;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MealTime {

	@Id
	@GeneratedValue
	private Long id;
	
	private String timeOfDay;
	
	@OneToMany(mappedBy = "mealTime")
	private Set<MenuItem> menuItemSet;
	
	public Set<MenuItem> getMenuItemSet() {
		return menuItemSet;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	public MealTime(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	@Override
	public String toString() {
		return timeOfDay;
	}

	public MealTime() {
		
	}
	
	
	
}
