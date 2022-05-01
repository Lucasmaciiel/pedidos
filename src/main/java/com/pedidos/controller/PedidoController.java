package com.pedidos.controller;

import com.pedidos.model.Pedido;
import com.pedidos.model.dto.PedidoForm;
import com.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String create(PedidoForm pedidoForm){

        var newPedido = pedidoForm.pedidoMapper();
        pedidoService.save(newPedido);

        return "home";
    }


}
