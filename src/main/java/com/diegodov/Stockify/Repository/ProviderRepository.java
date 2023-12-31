package com.diegodov.Stockify.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegodov.Stockify.Model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{
    
}
