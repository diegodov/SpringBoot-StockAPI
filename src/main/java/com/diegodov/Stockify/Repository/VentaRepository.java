package com.diegodov.Stockify.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegodov.Stockify.Model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    
}
