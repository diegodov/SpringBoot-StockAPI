package com.diegodov.Stockify.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegodov.Stockify.Service.VentaService;

@Controller
@RequestMapping("/views/reporteVenta")
public class ReporteVentaController {    
    
    private VentaService ventaService;

    public ReporteVentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping("/")
    public String indexReporteVenta(Model model) {
        model.addAttribute("ventas", ventaService.findAllVentas());
        return "VentaViews/ventalist";
    }

}
