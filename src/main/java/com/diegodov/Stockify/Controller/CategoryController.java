package com.diegodov.Stockify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodov.Stockify.Model.Category;
import com.diegodov.Stockify.Service.CategoryService;

@RestController
public class CategoryController {
    
    @Autowired
    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String showAll(Model model) {
        List<Category> categoryList = categoryService.showAll();
        model.addAttribute("title", "Category list");
        model.addAttribute("categoryList", categoryList);
        return "";
    }

}
