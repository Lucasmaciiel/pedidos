package com.transacoes.financeiras.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido {

    private String     id;
    private String     nomeProduto;
    private BigDecimal valorNegociado;
    private LocalDate  dataEntrega;
    private String     urlProduto;
    private String     urlImagem;
    private BigDecimal valor;
    private String     descricao;

}
