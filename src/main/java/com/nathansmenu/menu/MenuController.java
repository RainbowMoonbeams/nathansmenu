package com.nathansmenu.menu;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

	@Resource
	private MealTimeRepository mealTimeRepo;

	@Resource
	private MenuItemRepository menuItemRepo;
	
	@Resource
	private TagRepository tagRepo;
	
	@RequestMapping("/mealtime")
	public String fetchMealTime(Model model) {
		model.addAttribute("mealTimeAttribute", mealTimeRepo.findAll());
		return "mealtime";
	}
	
	@RequestMapping("/mealsmenu")
	public String fetchMenuItem(@RequestParam("id") long id, Model model) {
		model.addAttribute(mealTimeRepo.findOne(id));
		return "mealsmenu";
	}
	
	@RequestMapping("/ingredients")
	public String fetchIngredients(@RequestParam("id") long id, Model model) {
		model.addAttribute(menuItemRepo.findOne(id));
		return "ingredients";
	}
	
}
