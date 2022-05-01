package com.lmg.pedidos.controller;

import com.lmg.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    public static final String NOME_VIEW = "home";

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/home")
    public ModelAndView findAll() {

        var pedidos = pedidoService.findAll();
        ModelAndView modelAndView = new ModelAndView(NOME_VIEW);
        modelAndView.addObject("pedidos", pedidos);

        return modelAndView;
    }
}
