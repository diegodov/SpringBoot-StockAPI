package com.diegodov.Stockify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegodov.Stockify.Model.Category;
import com.diegodov.Stockify.Service.CategoryService;

import jakarta.validation.Valid;

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
    public String add(Model model) {
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

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.showDetails(id);
        model.addAttribute("title", "Modify category");
        model.addAttribute("id", id);
        model.addAttribute("category", category);
        return "editcategory";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
        System.out.println("Registro eliminado");
        return "redirect:/views/categories/";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") long id, @Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            category.setId(id);
            return "update-user";
        }
        categoryService.save(category);
        return "redirect:/views/categories/";
    }

}
