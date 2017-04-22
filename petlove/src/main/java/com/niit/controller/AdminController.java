package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	CategoryDao categoryDAO;
	
	/*@RequestMapping("/adminhome")
	public ModelAndView adminHomePage()
	{
		return new ModelAndView("AdminHome");
	}*/
	
	
	//category code
	@RequestMapping("/admincat")
	public ModelAndView categoryd() {
		ModelAndView mv = new ModelAndView("AdminCategory");

		return mv;
	}

	@RequestMapping("/categories/all")
	public @ResponseBody List<Category> categoriesall() {

		return categoryDAO.allCategories();

	}

	@RequestMapping("/newcat")
	public ModelAndView newCategory() {
		ModelAndView mv = new ModelAndView("AddCategory", "category", new Category());
		mv.addObject("newcategory", true);
		return mv;
	}

	@RequestMapping("/addcategory")
	public String addCategory(@ModelAttribute("category") Category category, BindingResult result, ModelMap model) {
		System.out.println("entered add cateogy");

		categoryDAO.newCategory(category);

		return "AdminCategory";
	}

	@RequestMapping("/{id}/editcategory")
	public String eidtcategory(@PathVariable Integer id, ModelMap model) {
		model.addAttribute("editcategory", true);
		model.addAttribute("category", categoryDAO.getCategory(id));
		return "AddCategory";
	}

	@RequestMapping("/{id}/updatecategory")
	public String updateCategory(@ModelAttribute("category") Category category, BindingResult result, ModelMap model) {
		System.out.println("entered add cateogy");
		categoryDAO.updateCategory(category);

		model.addAttribute("categories", true);

		return "AdminCategory";
	}

	@RequestMapping("/{id}/deletecategory")
	public String deleteCategory(@PathVariable Integer id, ModelMap model) {

		categoryDAO.deleteCategory(id);

		model.addAttribute("categories", true);

		return "AdminCategory";
	}

}