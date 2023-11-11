package com.diegodov.Stockify.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.diegodov.Stockify.Model.Category;
import com.diegodov.Stockify.Model.Product;
import com.diegodov.Stockify.Model.Provider;
import com.diegodov.Stockify.Repository.CategoryRepository;
import com.diegodov.Stockify.Repository.ProductRepository;
import com.diegodov.Stockify.Repository.ProviderRepository;

@Service
public class ProductService {

   
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private ProviderRepository providerRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

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

            // Busca y asigna el proveedor y la categoría por sus IDs
            Optional<Provider> providerOptional = providerRepository.findById(providerId);
            Optional<Category> categoryOptional = categoryRepository.findById(categoryId);


            productRepository.save(product); // Guarda el producto actualizado en la base de datos
            return true;
        }

        return false; // Devuelve false si el producto no se encontró o no se pudo actualizar
    }

    






}