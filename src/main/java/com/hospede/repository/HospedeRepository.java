package com.hospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospede.entities.Hospede;


public interface HospedeRepository extends JpaRepository <Hospede,Long>  {

}
