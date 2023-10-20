package com.diegodov.Stockify.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodov.Stockify.Model.Category;
import com.diegodov.Stockify.Repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    //save category
    public void save(Category category){
        categoryRepository.save(category);
    }

    //delete category
    public void delete(Long id){
        categoryRepository.deleteById(id);
    }

    //show all categories
    public List<Category> showAll(){
        return categoryRepository.findAll();
    }

    //show details by id
    public Category showDetails(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    //update category
    public boolean updateCategoryName(Long id, String newCategoryName) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(newCategoryName);
            categoryRepository.save(category); // Guarda la categoría actualizada en la base de datos
            return true;
        }

        return false; // Devuelve false si la categoría no se encontró o no se pudo actualizar
    }

}
