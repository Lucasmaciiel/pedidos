package com.pedidos.service;

import com.pedidos.model.Pedido;
import com.pedidos.repository.PedidoRepository;
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

    public Pedido save(Pedido pedido) {
        var newPedido = pedidoRepository.save(pedido);
        System.out.println("Novo pedido criado com sucesso" + newPedido);
        return newPedido;
    }
}
