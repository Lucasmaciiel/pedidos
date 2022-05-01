package com.lmg.pedidos.controller;

import com.lmg.pedidos.model.dto.RequisicaoNovoPedido;
import com.lmg.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    public static final String FORMULARIO_VIEW = "formulario";
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao){
        return "formulario";
    }

    @PostMapping("novo")
    public String create(@Valid RequisicaoNovoPedido requisicao, BindingResult result){

        if (result.hasErrors()){
            return "formulario";
        }

        var newPedido = requisicao.pedidoMapper();
        pedidoService.save(newPedido);

        ModelAndView modelAndView = new ModelAndView(FORMULARIO_VIEW);
        modelAndView.addObject("requisicaoNovoPedido", requisicao);

        return "redirect:/home/aguardando";
    }


}
