package com.diegodov.Stockify.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.diegodov.Stockify.Model.Cart;
import com.diegodov.Stockify.Model.Product;
import com.diegodov.Stockify.Model.Venta;
import com.diegodov.Stockify.Service.ClientService;
import com.diegodov.Stockify.Service.ProductService;
import com.diegodov.Stockify.Service.VentaService;


@Controller
@RequestMapping("/views/venta")
public class RegisterVentaController {

    //Attributes
    private VentaService ventaService;
    private ProductService productService;
    private ClientService clientService;

    //Cart
    public static List<Cart> cart = new ArrayList<>();
    Double ventaTotal = 0.0;

    //Service injection through constructor 
    public RegisterVentaController(VentaService ventaService, ProductService productService, ClientService clientService) {
        this.ventaService = ventaService;
        this.productService = productService;
        this.clientService = clientService;
    }

    //Carga la vista de registrar venta y envia los atributos necesarios para mostrar los productos y el carrito de compras
    @GetMapping("/")
    public String indexRegisterVenta(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("venta", new Venta());
        model.addAttribute("products", products);
        model.addAttribute("cart", new Cart()); 
        model.addAttribute("cartList", cart); 
        model.addAttribute("ventaTotal", ventaTotal);
        return "VentaViews/ventaform";
    }

    //add to cart
    @PostMapping("/addtocart")
    public String addToCart(Long id, Integer quantity, Model model) {
        Product product = productService.findById(id);
        Cart cartItem = new Cart(product.getId(), product.getName(), product.getCategory(), product.getCost(), quantity, product.getCost() * quantity );
        cart.add(cartItem);
        model.addAttribute("cart", cart);
        ventaTotal += cartItem.getTotal();
        return "redirect:/views/venta/";
    }

    @PostMapping("/removeitem")
    public String removeCartItem(@RequestParam("index") int index, Model model) {
        if (index >= 0 && index < cart.size()) {
            Cart cartItem = cart.get(index);
            ventaTotal -= cartItem.getTotal();
            cart.remove(index);
        }
        model.addAttribute("cart", cart);
        return "redirect:/views/venta/";
    }

    //clean cart
    @GetMapping("/clean")
    public String cleanCart(Model model) {
        cart.clear();
        ventaTotal = 0.0;
        model.addAttribute("cart", cart);
        return "redirect:/views/venta/";
    }

    //save venta
    @PostMapping("/save")
    public String saveVenta(Venta venta, Model model) {
        venta.setTotal(ventaTotal);
        for (Cart cartItem : cart) {
            Product product = productService.findById(cartItem.getId());
            product.setStock(product.getStock() - cartItem.getQuantity());
            productService.save(product);
            Venta ventaItem = new Venta(product, cartItem.getQuantity(), cartItem.getCost(), cartItem.getTotal());
            ventaService.sellProduct(ventaItem);
        }
        cart.clear();
        ventaTotal = 0.0;
        model.addAttribute("cart", cart);
        return "redirect:/views/venta/";
    }
}



    



