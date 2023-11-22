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
import com.diegodov.Stockify.Model.Provider;
import com.diegodov.Stockify.Model.Category;
import com.diegodov.Stockify.Service.CategoryService;
import com.diegodov.Stockify.Service.ProductService;
import com.diegodov.Stockify.Service.ProviderService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/products")
public class ProductController {
    
    @Autowired
    private final ProductService productService;
    private final ProviderService providerService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, ProviderService providerService,
            CategoryService categoryService) {
        this.productService = productService;
        this.providerService = providerService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String showAll(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("title", "Lista de Productos");
        model.addAttribute("productList", productList);
        return "ProductViews/Product";
    }

    @GetMapping("/add")
    public String add(Model model) {
        List<Provider> providers = providerService.showAll();
        List<Category> categories = categoryService.showAll();
        Product Product = new Product();
        model.addAttribute("title", "Nuevo Producto");
        model.addAttribute("Product", Product);
        model.addAttribute("providers", providers);
        model.addAttribute("categories", categories);
        return "ProductViews/ProductForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product Product){
        productService.save(Product);
        return "redirect:/views/products/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        List<Provider> providers = providerService.showAll();
        List<Category> categories = categoryService.showAll();
        Product Product = productService.findById(id);
        model.addAttribute("title", "Editar Producto");
        model.addAttribute("id", id);
        model.addAttribute("Product", Product);
        model.addAttribute("providers", providers);
        model.addAttribute("categories", categories);
        return "ProductViews/ProductUpd";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productService.delete(id);
        System.out.println("Registro eliminado");
        return "redirect:/views/products/";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") long id, @Valid Product Product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Product.setId(id);
            return "update-user";
        }
        productService.save(Product);
        return "redirect:/views/products/";
    }

}
