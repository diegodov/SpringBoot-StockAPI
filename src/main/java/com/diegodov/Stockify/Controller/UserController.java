package com.diegodov.Stockify.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegodov.Stockify.Model.User;
import com.diegodov.Stockify.Service.UserService;

@Controller
@RequestMapping("views/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(User user) {
        userService.registerUser(user);
        return "redirect:/views/user/list";
    }

    @GetMapping("/list")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "UserViews/userlist";
    }

    @GetMapping("/form")
    public String showUserForm(Model model) {
        model.addAttribute("title", "Nuevo Usuario");
        model.addAttribute("user", new User());
        return "UserViews/registeruser";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        userService.registerUser(user);
        return "redirect:/UserViews/userlist";
    }
    
}
