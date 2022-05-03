package com.lmg.pedidos.service;

import com.lmg.pedidos.model.Pedido;
import com.lmg.pedidos.model.StatusPedido;
import com.lmg.pedidos.repository.PedidoRepository;
import com.lmg.pedidos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class PedidoService {

   @Autowired
   private PedidoRepository pedidoRepository;

   @Autowired
   private UserRepository userRepository;

    public List<Pedido> findAllByUser(String userName) {
        return pedidoRepository.findAllByUser(userName);
    }

    public Pedido save(Pedido pedido) {

        var userName = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userRepository.findByUsername(userName);

        if (Objects.isNull(user)){
            throw new EntityNotFoundException("Usuário não encontrado");
        }
        pedido.setUser(user);

        var newPedido = pedidoRepository.save(pedido);
        System.out.println("Novo pedido criado com sucesso" + newPedido);
        return newPedido;
    }

    public List<Pedido> buscarPorStatusPedidoEUsuario(StatusPedido statusPedido) {
        var userName = SecurityContextHolder.getContext().getAuthentication().getName();

        return pedidoRepository.findByStatusPedidoAndUser_Username(statusPedido, userName);
    }
}
