package io.github.indigo.domain.repository;

import io.github.indigo.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {



}
