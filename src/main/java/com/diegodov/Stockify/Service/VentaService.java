package com.diegodov.Stockify.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diegodov.Stockify.Model.Venta;
import com.diegodov.Stockify.Repository.VentaRepository;

@Service
public class VentaService {
    
    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    // list all ventas
    public List<Venta> findAllVentas() {
        return ventaRepository.findAll();
    }

    // sell a product
    public Venta sellProduct(Venta venta) {
        return ventaRepository.save(venta);
    }

    // find a venta by id
    public Venta findVentaById(Long id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta by id " + id + " was not found"));
    }

    // delete a venta
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    // update a venta
    public Venta updateVenta(Venta venta) {
        return ventaRepository.save(venta);
    }
}
