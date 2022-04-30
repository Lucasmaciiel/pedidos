package com.transacoes.financeiras.controller;

import com.transacoes.financeiras.model.Pedido;
import com.transacoes.financeiras.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class PedidoController {


    public static final String HOME = "home";

//    @Autowired
//    private PedidoService pedidoService;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/home")
    public String home(Model model){

        Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
        List<Pedido> pedidos = query.getResultList();

//        pedidoService.findById(1L);

        model.addAttribute("pedidos", pedidos);

        return HOME;
    }
}
