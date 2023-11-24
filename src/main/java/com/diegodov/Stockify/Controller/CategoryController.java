package com.diegodov.Stockify.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegodov.Stockify.Model.Category;
import com.diegodov.Stockify.Service.CategoryService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    // Muestra todos los registros
    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("title", "Lista de Categorias");
        model.addAttribute("categories", categoryService.findAll());
        return "CategoryViews/Category";
    }

    // Agrega un registro nuevo
    @GetMapping("/add")
    public String add(Model model) {
        Category category = new Category();
        model.addAttribute("title", "Nueva Categoria");
        model.addAttribute("category", category);
        return "CategoryViews/CategoryForm";
    }

    // Guarda el registro nuevo
    @PostMapping("/save")
    public String save(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/views/categories/";
    }

    // Edita un registro enviando el id a la vista de edicion
    @GetMapping("/edit/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("title", "Editar categoria");
        model.addAttribute("id", id);
        model.addAttribute("category", categoryService.findById(id));
        return "CategoryViews/UpdateCategory";
    }

    // Elimina un registro
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
        System.out.println("Registro eliminado");
        return "redirect:/views/categories/";
    }

    // Actualiza un registro existente y lo guarda en la base de datos
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            category.setId(id);
            return "update-user";
        }
        categoryService.save(category);
        return "redirect:/views/categories/";
    }

}
