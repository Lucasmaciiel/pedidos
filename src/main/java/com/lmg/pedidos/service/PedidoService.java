package com.lmg.pedidos.service;

import com.lmg.pedidos.model.Pedido;
import com.lmg.pedidos.model.StatusPedido;
import com.lmg.pedidos.repository.PedidoRepository;
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

    public List<Pedido> buscarPorStatusPedido(StatusPedido statusPedido) {
        return pedidoRepository.findByStatusPedido(statusPedido);
    }
}
