package com.projetoLoginMariaDalacorte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoLoginMariaDalacorte.entity.Produtos;

public interface ProdutoRepository extends JpaRepository <Produtos, Long>{

}
