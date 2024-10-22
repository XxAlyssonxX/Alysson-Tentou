package com.hospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospede.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository <Veiculo,Long>  {

}