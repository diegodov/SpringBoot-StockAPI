package com.diegodov.Stockify.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodov.Stockify.Model.Product;
import com.diegodov.Stockify.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //save
    public void save(Product product) {
        LocalDate now = LocalDate.now();
        product.setDateGetted(now);
        productRepository.save(product);
    }

    //delete
    public void delete(Long id){
        productRepository.deleteById(id);
    }

    //find by id
    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    
    //find all
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //update
    public boolean update(Long id, String name, Double cost, int stock, Long providerId, Long categoryId) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(name);
            product.setCost(cost);
            product.setStock(stock);
            productRepository.save(product); 
            return true;
        }
        return false; 
    }

}