package com.diegodov.Stockify.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegodov.Stockify.Model.Product;
import com.diegodov.Stockify.Model.Rol;
import com.diegodov.Stockify.Model.User;
import com.diegodov.Stockify.Service.RolService;
import com.diegodov.Stockify.Service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/user")
public class UserController {

    private final UserService userService;
    private final RolService rolService;

    public UserController(UserService userService, RolService rolService) {
        this.userService = userService;
        this.rolService = rolService;
    }

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("title", "Lista de Usuarios");
        model.addAttribute("users", userService.getAllUsers());
        return "UserViews/userlist";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id);
        List<Rol> roles = rolService.getAllRoles();
        model.addAttribute("title", "Modificar Usuario");
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "UserViews/upduser";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }
        userService.registerUser(user);
        return "redirect:/views/user/";
    }

    

    @PostMapping("/save")
    public String saveUser(User user) {
        userService.registerUser(user);
        return "redirect:/views/user/";
    }

    @GetMapping("/form")
    public String showUserForm(Model model) {
        model.addAttribute("title", "Nuevo Usuario");
        model.addAttribute("roles", rolService.getAllRoles());
        model.addAttribute("user", new User());
        return "UserViews/registeruser";
    }
 
}
