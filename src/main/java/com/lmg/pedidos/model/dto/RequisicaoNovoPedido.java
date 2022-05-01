package com.lmg.pedidos.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lmg.pedidos.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
public class RequisicaoNovoPedido {

    @NotBlank
    @Min(5)
    @Max(200)
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
