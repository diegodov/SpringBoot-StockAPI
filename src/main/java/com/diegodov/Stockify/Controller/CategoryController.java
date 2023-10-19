package com.diegodov.Stockify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegodov.Stockify.Model.Category;
import com.diegodov.Stockify.Service.CategoryService;

@Controller
@RequestMapping("/views/categories")
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
        return "category";
    }

    @GetMapping("/addcategory")
    public String addCategory(Model model) {
        Category category = new Category();
        model.addAttribute("title", "Categories");
        model.addAttribute("category", category);
        return "categoryform";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/views/categories/";
    }

}
