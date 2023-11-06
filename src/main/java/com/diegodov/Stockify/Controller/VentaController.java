package com.diegodov.Stockify.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.diegodov.Stockify.Model.Product;
import com.diegodov.Stockify.Model.Venta;
import com.diegodov.Stockify.Service.ProductService;
import com.diegodov.Stockify.Service.VentaService;

@Controller
@RequestMapping("/views/venta")
public class VentaController {

    private final VentaService ventaService;
    private final ProductService productService;

    public VentaController(VentaService ventaService, ProductService productService) {
        this.ventaService = ventaService;
        this.productService = productService;
    }

    @GetMapping("/form")
    public String form(Product product, Venta venta, Model model) {
        model.addAttribute("products", productService.showAll());
        model.addAttribute("venta", venta);
        return "VentaViews/ventaform";
    }  

}
