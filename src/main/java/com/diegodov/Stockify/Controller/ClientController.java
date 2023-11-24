package com.diegodov.Stockify.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegodov.Stockify.Model.Client;
import com.diegodov.Stockify.Service.ClientService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Muestra todos los registros
    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("title", "Lista de Clientes");
        model.addAttribute("clients", clientService.findAll());
        return "ClientViews/clientlist";
    }

    // Guarda un registro
    @PostMapping("/save")
    public String save(Client client) {
        clientService.saveClient(client);
        return "redirect:/views/clients/";
    }

    // Agrega un registro nuevo
    @GetMapping("/add")
    public String add(Model model) {
        Client client = new Client();
        model.addAttribute("title", "Nuevo Cliente");
        model.addAttribute("client", client);
        return "ClientViews/clientform";
    }

    // Elimina un registro
    @GetMapping("/delete")
    public String delete(Long id) {
        clientService.deleteClient(id);
        return "redirect:/views/clients/";
    }
    
    // Busca un registro por id y lo muestra
    @GetMapping("/edit/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("title", "Editar Cliente");
        model.addAttribute("id", id);
        model.addAttribute("client", clientService.findById(id));
        return "ClientViews/clientdetails";
    }

    // Actualiza un registro
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            client.setId(id);
            return "ClientViews/clientdetails";
        }
        clientService.saveClient(client);
        return "redirect:/views/clients/";
    }

}
