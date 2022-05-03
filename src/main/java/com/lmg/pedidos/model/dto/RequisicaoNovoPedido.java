package com.lmg.pedidos.model.dto;

import com.lmg.pedidos.model.Pedido;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
public class RequisicaoNovoPedido {

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String urlProduto;

    @NotBlank
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
