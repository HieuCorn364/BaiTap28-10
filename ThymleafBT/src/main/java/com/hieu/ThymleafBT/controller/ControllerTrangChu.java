package com.hieu.ThymleafBT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hieu.ThymleafBT.entity.CategoryEntity;
import com.hieu.ThymleafBT.service.CategoryService;


@Controller
public class ControllerTrangChu {
	
	@Autowired
    private CategoryService categoryService;
	
	@GetMapping("/category")
    public String listCategories(Model model,
                                 @RequestParam(value = "keyword", required = false) String keyword,
                                 @RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "5") int size) {
        Page<CategoryEntity> categories = categoryService.getCategories(keyword, page, size);
        model.addAttribute("categories", categories);
        model.addAttribute("keyword", keyword);
        return "category/list";
    }
	@GetMapping("/new")
    public String createCategoryForm(Model model) {
        model.addAttribute("category", new CategoryEntity());
        return "category/form";
    }

    @PostMapping
    public String saveCategory(@ModelAttribute CategoryEntity category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable Long id, Model model) {
    	CategoryEntity category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "category/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}
