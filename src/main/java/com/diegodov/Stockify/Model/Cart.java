package com.diegodov.Stockify.Model;

import java.util.ArrayList;
import java.util.List;

// cart class to add products to cart and then to the sale and decrement or increment the stock of the product in the database
public class Cart extends Product {

    public Integer quantity;

    public Double total;

    public Double ventaTotal;

    public static List<Cart> cart = new ArrayList<>();

    public Double getVentaTotal() {
        return ventaTotal;
    }

    public void setVentaTotal(Double ventaTotal) {
        this.ventaTotal = ventaTotal;
    }
    
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cart() {
    }

    public Cart(Long id, String name, Category category, double cost, Integer quantity, Double total) {
        super(id, name, category, cost);
        this.quantity = quantity;
        this.total = total;
    }

    public static void add(Cart cartItem) {
        cart.add(cartItem);
    }

    public static void remove(Product product) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId() == product.getId()) {
                cart.remove(i);
            }
        }
    }

    public static void clear() {
        cart.clear();
    }

    public static List<Cart> getCart() {
        return cart;
    }

    public static void setCart(List<Cart> cart) {
        Cart.cart = cart;
    }

    public static void updateStock(Product product) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId() == product.getId()) {
                product.setStock(product.getStock() - cart.get(i).getQuantity());
            }
        }
    }



}