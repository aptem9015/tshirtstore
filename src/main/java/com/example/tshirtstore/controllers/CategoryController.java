package com.example.tshirtstore.controllers;

import com.example.tshirtstore.entities.Category;
import com.example.tshirtstore.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/categories")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/add_category";
    }


    @PostMapping("/admin/add_category")
    public String addCategorySubmit(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/add_category";
        } else {
            categoryService.saveCategory(category);
            return "redirect:/admin/categories";
        }
    }
}