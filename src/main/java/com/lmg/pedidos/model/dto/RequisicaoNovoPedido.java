package com.lmg.pedidos.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lmg.pedidos.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
public class PedidoDto {

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String urlProduto;

    @NotBlank
    private String urlImagem;

    @NotBlank
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
