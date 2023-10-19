package com.diegodov.Stockify.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegodov.Stockify.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
