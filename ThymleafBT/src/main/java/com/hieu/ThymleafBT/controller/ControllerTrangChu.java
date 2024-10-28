package com.hieu.ThymleafBT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
