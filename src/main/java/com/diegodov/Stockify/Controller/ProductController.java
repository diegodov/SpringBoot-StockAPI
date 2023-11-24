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
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegodov.Stockify.Model.Product;
import com.diegodov.Stockify.Service.CategoryService;
import com.diegodov.Stockify.Service.ProductService;
import com.diegodov.Stockify.Service.ProviderService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    @Autowired
    private ProviderService providerService;
    @Autowired
    private CategoryService categoryService;

    // Mostrar todos los registros
    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("title", "Lista de Productos");
        model.addAttribute("products", productService.findAll());
        return "ProductViews/Product";
    }

    // Crear nuevo registro
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("title", "Nuevo Producto");
        model.addAttribute("Product", new Product());
        model.addAttribute("providers", productService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "ProductViews/ProductForm";
    }

    // Guardar registro
    @PostMapping("/save")
    public String save(@ModelAttribute Product Product){
        productService.save(Product);
        return "redirect:/views/products/";
    }

    // Editar registro por id
    @GetMapping("/edit/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("title", "Editar Producto");
        model.addAttribute("id", id);
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("providers", providerService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "ProductViews/ProductUpd";
    }

    // Eliminar registro por id
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productService.delete(id);
        System.out.println("Registro eliminado");
        return "redirect:/views/products/";
    }

    // Actualizar registro
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setId(id);
            return "update-product";
        }
        productService.save(product);
        return "redirect:/views/products/";
    }

}
