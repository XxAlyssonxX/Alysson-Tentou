package com.hospede.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospede.entities.Hospede;
import com.hospede.repository.HospedeRepository;

@Service
public class HospedeService {

private final HospedeRepository hospedeRepository;
	
	@Autowired
	public HospedeService(HospedeRepository hospedeRepository) {
		this.hospedeRepository = hospedeRepository;
	}

	public List<Hospede> getAllHospede() {
		return hospedeRepository.findAll();
	}

	public Optional<Hospede> getHospedeById(Long id) {
		return hospedeRepository.findById(id);
	}

	public Hospede salvarHospede(Hospede hospede) {
		return hospedeRepository.save(hospede);
	}

	public Hospede updateHospede(Hospede hospede) {
		if(hospedeRepository.existsById(hospede.getId())) {
			return hospedeRepository.save(hospede);
		}	else {
			throw new RuntimeException("Hospede nao encontrado");
			}
		}


	public boolean deleteHospede(Long id) {
		Optional<Hospede> existingHospede = hospedeRepository.findById(id);
		if (existingHospede.isPresent()) {
			hospedeRepository.deleteById(id);
			return true;
		}
		return false;
	}

}