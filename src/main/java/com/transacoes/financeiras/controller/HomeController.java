package com.transacoes.financeiras.controller;

import com.transacoes.financeiras.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {


    public static final String HOME = "home";

    @GetMapping("/home")
    public String home(Model model){

        Pedido pedido = Pedido.builder()
                .nomeProduto("Notebook Lenovo Ultrafino")
                .urlImagem("https://images-americanas.b2w.io/produtos/01/00/img/4296134/9/4296134998_1SZ.jpg")
                .urlProduto("https://www.americanas.com.br/produto/4296134971?chave=dk_hm_bn_4_2_ge&offerId=61b204a2d9fd6edeec018521&cor=PRATA&voltagem=BIVOLT")
                .descricao("Descricao para esse pedido")
                .valor(BigDecimal.valueOf(5056))
                .build();

        Pedido pedido2 = Pedido.builder()
                .nomeProduto("Notebook HP Envy i7")
                .urlImagem("https://images-americanas.b2w.io/produtos/01/00/img/4296134/9/4296134998_1SZ.jpg")
                .urlProduto("https://www.americanas.com.br/produto/4296134971?chave=dk_hm_bn_4_2_ge&offerId=61b204a2d9fd6edeec018521&cor=PRATA&voltagem=BIVOLT")
                .descricao("Descricao para esse pedido")
                .valor(BigDecimal.valueOf(500))
                .build();

        List<Pedido> pedidos = Arrays.asList(pedido, pedido2);
        model.addAttribute("pedidos", pedidos);

        return HOME;
    }
}
