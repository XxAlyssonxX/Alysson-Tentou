package com.hospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospede.entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto,Long>  {

}
