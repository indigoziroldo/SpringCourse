package io.github.indigo.domain.repository;

import io.github.indigo.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface Clientes extends JpaRepository<Cliente, Integer> {


    List <Object> findByNomeLike(String nome);
}
