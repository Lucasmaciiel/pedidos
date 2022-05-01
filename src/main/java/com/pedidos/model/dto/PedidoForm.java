package com.pedidos.model.dto;

import com.pedidos.model.Pedido;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PedidoForm {

    private String nomeProduto;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    public Pedido pedidoMapper() {
        return Pedido.builder()
                .descricao(this.descricao)
                .nomeProduto(this.nomeProduto)
                .urlImagem(this.urlImagem)
                .urlProduto(this.urlProduto)
                .build();
    }
}
