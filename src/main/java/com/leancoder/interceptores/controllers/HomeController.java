package com.leancoder.interceptores.controllers;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leancoder.models.domains.Country;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private Country country;

    @GetMapping({"/", ""})
    public String Home(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("country", country);
        return "home";
    }

    @PostMapping("/procces-region")
    public String proccesRegion(Country country, Model model) {
        System.out.println(country.getName());
        this.country.setName(country.getName());
        return "redirect:/home/users";
    }
    
    @GetMapping("/users")
    public String Users(Model model) {
        model.addAttribute("title", "Users");
        model.addAttribute("data", "usuarios");
        return "users";
    }

    @GetMapping("/prohibido")
    public String Prohibido(Model model) {
        return "prohibido";
    }

    @GetMapping("/random")
    public String Random() {
        return "random";
    }
    

}
