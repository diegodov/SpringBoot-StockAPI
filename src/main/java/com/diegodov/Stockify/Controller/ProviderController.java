package com.diegodov.Stockify.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegodov.Stockify.Model.Provider;
import com.diegodov.Stockify.Service.ProviderService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/providers")
public class ProviderController {
    
    @Autowired
    private ProviderService providerService;

    // Muestra todos los registros
    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("title", "Lista de Proveedores");
        model.addAttribute("providers", providerService.findAll());
        return "ProviderViews/Provider";
    }

    // Agrega un registro nuevo
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("title", "Nuevo Proveedor");
        model.addAttribute("provider", new Provider());
        return "ProviderViews/ProviderForm";
    }

    // Guarda el registro nuevo
    @PostMapping("/save")
    public String save(@ModelAttribute Provider provider){
        providerService.save(provider);
        return "redirect:/views/providers/";
    }

    // Edita un registro enviando el id a la vista de edicion
    @GetMapping("/edit/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("title", "Editar Proveedor");
        model.addAttribute("id", id);
        model.addAttribute("provider", providerService.findById(id));
        return "ProviderViews/ProviderUpd";
    }

    // Elimina un registro
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        providerService.delete(id);
        return "redirect:/views/providers/";
    }

    // Actualiza un registro
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @Valid Provider provider, BindingResult result, Model model) {
        if (result.hasErrors()) {
            provider.setId(id);
            return "update-provider";
        }
        providerService.save(provider);
        return "redirect:/views/providers/";
    }
}
