package com.diegodov.Stockify.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping({"/index","/"})
    public String index(){
        return "index.html";
    }

    @GetMapping ("/login")
    public String login(){
        return "LoginViews/Login";
    }

}
