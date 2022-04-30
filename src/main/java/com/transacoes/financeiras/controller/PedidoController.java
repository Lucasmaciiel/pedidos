package com.transacoes.financeiras.controller;

import com.transacoes.financeiras.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PedidoController {


    public static final String HOME = "home";

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/home")
    public String findAll(Model model) {

        var pedidos = pedidoService.findAll();
        model.addAttribute("pedidos", pedidos);

        return HOME;
    }
}
