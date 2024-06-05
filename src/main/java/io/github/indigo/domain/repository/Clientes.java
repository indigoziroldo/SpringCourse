package io.github.indigo.domain.repository;

import io.github.indigo.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface Clientes extends JpaRepository<Cliente, Integer> {

    // @Query(value = "select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true) // using sql native
    // List <Cliente> encontrarPorNome(@Param("nome") String nome);
    @Query(value = "select c from Cliente c where c.nome like :nome ") // using hql
    List <Cliente> encontrarPorNome(@Param("nome") String nome);

    boolean existsByNome(String nome);



}
