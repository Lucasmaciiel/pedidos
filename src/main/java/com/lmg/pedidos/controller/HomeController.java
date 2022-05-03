package com.lmg.pedidos.controller;

import com.lmg.pedidos.model.StatusPedido;
import com.lmg.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(value = "/home")
public class HomeController {


    public static final String NOME_VIEW = "home";
    public static final String PEDIDOS = "pedidos";
    public static final String STATUS = "status";

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ModelAndView buscarTodos(Principal principal) { // principal pega as informações do usuário logado

        var pedidos = pedidoService.findAllByUser(principal.getName());
        ModelAndView modelAndView = new ModelAndView(NOME_VIEW);
        modelAndView.addObject(PEDIDOS, pedidos);

        return modelAndView;
    }

    @GetMapping("/{status}")
    public ModelAndView buscarTodosPorStatus(@PathVariable("status") String statusPedido) {

        var pedidos = pedidoService.buscarPorStatusPedidoEUsuario(StatusPedido.valueOf(statusPedido.toUpperCase()));
        ModelAndView modelAndView = new ModelAndView(NOME_VIEW);
        modelAndView.addObject(PEDIDOS, pedidos);
        modelAndView.addObject(STATUS, statusPedido);

        return modelAndView;
    }

    /**
     * Redireciona para página home, caso o status não exista no enum
     *
     * @return página que deve ser redirecioanda
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}
