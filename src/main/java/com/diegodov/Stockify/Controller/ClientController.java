package com.diegodov.Stockify.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegodov.Stockify.Model.Category;
import com.diegodov.Stockify.Model.Client;
import com.diegodov.Stockify.Service.ClientService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("title", "Client list");
        model.addAttribute("clientList", clientService.findAll());
        return "ClientViews/clientlist";
    }

    @PostMapping("/save")
    public String save(Client client) {
        clientService.saveClient(client);
        return "redirect:/views/clients/";
    }

    @GetMapping("/form")
    public String form(Model model) {
        Client client = new Client();
        model.addAttribute("title", "New Client");
        model.addAttribute("client", client);
        return "ClientViews/clientform";
    }

    @GetMapping("/delete")
    public String delete(Long id) {
        clientService.deleteClient(id);
        return "redirect:/views/clients/";
    }
    
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("title", "Editar Cliente");
        model.addAttribute("id", id);
        model.addAttribute("client", client);
        return "ClientViews/clientdetails";
    }

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
