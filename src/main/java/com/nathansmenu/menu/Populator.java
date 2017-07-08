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
	
	@Resource
	private TagRepository tagRepo;

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
	
	Tag savory = new Tag("savory");
	Tag light = new Tag("light");
	Tag eatOnTheGo = new Tag("eat on-the-go");
	Tag satisfying = new Tag("satisfying");
	
	tagRepo.save(savory);
	tagRepo.save(light);
	tagRepo.save(eatOnTheGo);
	tagRepo.save(satisfying);
	
	MenuItem eggSandwich = new MenuItem("Egg Sandwich", breakfast, "egg, bread", "delicious, easy to eat on the go", eatOnTheGo, satisfying);
	MenuItem eggOverGreens = new MenuItem("Egg over a bed of Greens", breakfast, "egg cooked over-easy, laid over a bed of spring mix, topped with capers, a dollop of mayo and a spinkle of freshly ground black pepper", "delectible, feel like a queen for the day", savory, satisfying);
	MenuItem leftoverPizza = new MenuItem("Leftover Pizza", lunch, "bread, cheese, veggies", "eat cold, eat on the go, happy belly", eatOnTheGo);
	MenuItem tunaSaladSalad = new MenuItem("Tuna Salad Salad", lunch, "laid over a bed of spring mix, topped with capers, a dollop of mayo and a spinkle of freshly ground black pepper", "delectible, feel like a queen for the day", satisfying);
	MenuItem salmonAndSides = new MenuItem("Salmon and Sides", dinner, "salmon, baked sweet potato, and string breans", "tasty, healthy, and satisfying!", savory, satisfying);
	MenuItem gnocchiWithSauce = new MenuItem("Gnocchi with Sauce & Brussel Sprouts", dinner, "perfectly poached gnocchi with a home made Roasted Red Pepper & butternut squash sauce, with a side of roasted brussel sprouts", "healthy comfort food at its best!", savory, satisfying);
	MenuItem olivesAndCrackers = new MenuItem("Olives & Crackers", snack, "marinated olives & garlic, crispy water crackers, and artisan cheese", "a delectible and light snack", light);
	MenuItem beetsAndGoatCheese = new MenuItem("Beets and Goat Cheese", snack, "pickled beets and a creamy & crumbly goat cheese drizled with honey and balsalmic vinaigrette, with crispy water crackers", "a tangy, light snack", light);
	
	menuItemRepo.save(eggSandwich);
	menuItemRepo.save(eggOverGreens);
	menuItemRepo.save(leftoverPizza);
	menuItemRepo.save(tunaSaladSalad);
	menuItemRepo.save(salmonAndSides);
	menuItemRepo.save(gnocchiWithSauce);
	menuItemRepo.save(olivesAndCrackers);
	menuItemRepo.save(beetsAndGoatCheese);
	}

}
