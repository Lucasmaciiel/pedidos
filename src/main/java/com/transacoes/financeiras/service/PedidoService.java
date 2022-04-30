package com.transacoes.financeiras.service;

import com.transacoes.financeiras.model.Pedido;
import com.transacoes.financeiras.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

   @Autowired
   private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}
