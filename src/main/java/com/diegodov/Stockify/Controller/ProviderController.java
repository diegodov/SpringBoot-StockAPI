package com.diegodov.Stockify.Controller;

import java.util.List;

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
    private final ProviderService ProviderService;

    ProviderController(ProviderService ProviderService) {
        this.ProviderService = ProviderService;
    }

    @GetMapping("/")
    public String showAll(Model model) {
        List<Provider> providerList = ProviderService.findAll();
        model.addAttribute("title", "Lista de Proveedores");
        model.addAttribute("providerList", providerList);
        return "ProviderViews/Provider";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Provider provider = new Provider();
        model.addAttribute("title", "Nuevo Proveedor");
        model.addAttribute("provider", provider);
        return "ProviderViews/ProviderForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Provider provider){
        ProviderService.save(provider);
        return "redirect:/views/providers/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Provider provider = ProviderService.details(id);
        model.addAttribute("title", "Editar Proveedor");
        model.addAttribute("id", id);
        model.addAttribute("provider", provider);
        return "ProviderViews/ProviderUpd";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        ProviderService.delete(id);
        System.out.println("Registro eliminado");
        return "redirect:/views/providers/";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") long id, @Valid Provider Provider, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Provider.setId(id);
            return "update-user";
        }
        ProviderService.save(Provider);
        return "redirect:/views/providers/";
    }

}
