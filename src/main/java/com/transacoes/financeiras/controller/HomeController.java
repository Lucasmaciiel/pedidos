package com.transacoes.financeiras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String home(Model model){
        return "home";
    }
}
