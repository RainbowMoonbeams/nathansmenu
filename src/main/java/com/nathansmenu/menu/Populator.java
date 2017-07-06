package com.nathansmenu.menu;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

	@Resource
	private MealTimeRepository mealTimeRepo;

	@Resource
	private MenuItemRepository menuItemRepo;

	@Override
	public void run(String... args) throws Exception {

	MealTime breakfast = new MealTime("Breakfast");
	MealTime lunch = new MealTime("Lunch");
	MealTime dinner = new MealTime("Dinner");
	MealTime snack = new MealTime("Snack");
	
	mealTimeRepo.save(breakfast);
	mealTimeRepo.save(lunch);
	mealTimeRepo.save(dinner);
	mealTimeRepo.save(snack);
	
	MenuItem eggSandwich = new MenuItem("Egg Sandwich", breakfast, "egg, bread", "delicious, easy to eat on the go");
	MenuItem eggOverGreens = new MenuItem("Egg over a bed of Greens", breakfast, "egg cooked over-easy, laid over a bed of spring mix, topped with capers, a dollop of mayo and a spinkle of freshly ground black pepper", "delectible, feel like a queen for the day");
	MenuItem leftoverPizza = new MenuItem("Leftover Pizza", lunch, "bread, cheese, veggies", "eat cold, eat on the go, happy belly");
	MenuItem tunaSaladSalad = new MenuItem("Tuna Salad Salad", lunch, "laid over a bed of spring mix, topped with capers, a dollop of mayo and a spinkle of freshly ground black pepper", "delectible, feel like a queen for the day");
	MenuItem salmonAndSides = new MenuItem("Salmon and Sides", dinner, "salmon, baked sweet potato, and string breans", "tasty, healthy, and satisfying!");
	MenuItem olivesAndCrackers = new MenuItem("Olives & Crackers", snack, "marinated olives & garlic, crispy water crackers, and artisan cheese", "a delectible and light snack");
	
	menuItemRepo.save(eggSandwich);
	menuItemRepo.save(eggOverGreens);
	menuItemRepo.save(leftoverPizza);
	menuItemRepo.save(tunaSaladSalad);
	menuItemRepo.save(salmonAndSides);
	menuItemRepo.save(olivesAndCrackers);
	
	}

}
