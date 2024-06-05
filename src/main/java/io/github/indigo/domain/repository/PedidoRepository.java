package io.github.indigo.domain.repository;

import io.github.indigo.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO =====>>>> Data Acess Only


public interface PedidoRepository extends JpaRepository<Pedido, Integer> {


}
