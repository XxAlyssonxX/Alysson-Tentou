package com.hospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospede.entities.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente,Long>  {

}