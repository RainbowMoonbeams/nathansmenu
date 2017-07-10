package com.nathansmenu.menu;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/tag")
	public String fetchTag(@RequestParam("id") long id, Model model) {
		model.addAttribute(tagRepo.findOne(id));
		return "tag";
	}

	@RequestMapping("/tag/delete")
	public String deleteTag(@RequestParam long tagId, @RequestParam long menuItemId) {
		Tag toDelete = tagRepo.findOne(tagId);
		for (MenuItem item : toDelete.getMenuItemTag()) {
			item.remove(toDelete);
			menuItemRepo.save(item);
		}
		tagRepo.delete(toDelete);
		return "redirect:/ingredients?id=" + menuItemId;
	}

	@RequestMapping("/tag/add")
	public String createTag(@RequestParam(value = "id") long id, String name) {
		Tag tag = new Tag(name);
		tagRepo.save(tag);
		MenuItem items = menuItemRepo.findOne(id);
		items.add(tag);
		menuItemRepo.save(items);
		return "redirect:/ingredients?id=" + id;

	}

	@RequestMapping("/tags")
	public String fetchTags(Model model) {
		model.addAttribute(tagRepo.findAll());
		return "tags";
	}
}
