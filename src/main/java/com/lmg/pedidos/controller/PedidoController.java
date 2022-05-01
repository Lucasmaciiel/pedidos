package com.lmg.pedidos.controller;

import com.lmg.pedidos.model.dto.PedidoDTO;
import com.lmg.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("formulario")
    public String formulario(){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String create(PedidoDTO pedidoDTO){

        var newPedido = pedidoDTO.pedidoMapper();
        pedidoService.save(newPedido);

        return "home";
    }


}
