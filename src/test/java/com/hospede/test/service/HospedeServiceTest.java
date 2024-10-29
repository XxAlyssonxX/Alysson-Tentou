package com.hospede.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospede.entities.Hospede;
import com.hospede.repository.HospedeRepository;
import com.hospede.services.HospedeService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class HospedeServiceTest {

	@Autowired
	private HospedeService hospedeService;
	
	@Autowired
	private HospedeRepository hospedeRepository;
	
	@BeforeEach
	void setUp() {
		hospedeRepository.deleteAll();
	}
	
	@DisplayName("Testando salva hóspede")
	@Test
	void testSalvarHospede () {
		Hospede hospede = new Hospede (null, "Julia maria", "julia@gmail.com", "(00)000-000");
		
		Hospede resultado = hospedeService.salvarHospede(hospede);
		
		assertNotNull(resultado);
		assertEquals("Julia maria", resultado.getNome());
		assertTrue(resultado.getId() > 0);
	}
	
	@DisplayName("Testando listar todos Hóspedes")
	@Test
	void testListarTodos() {
		Hospede hospede1 = new Hospede(null, "Julia maria", "julia@gmail.com", "(00)000-000");
		Hospede hospede2 = new Hospede(null, "Julio fernando", "julio@gmail.com", "(00)000-000");
		
		hospedeService.salvarHospede(hospede1);
		hospedeService.salvarHospede(hospede2);
		
		List<Hospede> resultado = hospedeService.getAllHospede();
		
		assertNotNull(resultado);
		assertEquals(2, resultado.size());
	}
	
	@DisplayName("Testando buscar por id os Hóspede")
	@Test
	void testBuscarPorId() {
		Hospede hospede = new Hospede(null, "Julia maria", "julia@gmail.com", "(00)000-000");
		
		Hospede salvo = hospedeService.salvarHospede(hospede);
		Optional<Hospede> resultado = hospedeService.getHospedeById(salvo.getId());
		
		assertTrue(resultado.isPresent());
		assertEquals("Julia maria", resultado.get().getNome());
	}
	
	@DisplayName("Testando atualizar Hóspede")
	@Test
	void testAtualizarHospede () {
		Hospede hospede = new Hospede(null, "Julia maria", "Julia@gmail.com", "(00)000-000");
		Hospede salvo = hospedeService.salvarHospede(hospede);
		
		salvo.setNome("Leonardo");
		salvo.setEmail("Leonardo@gmail.com");
		
		Hospede atualizado = hospedeService.updateHospede(salvo);
		
		assertNotNull(atualizado);
		assertEquals("Leonardo", atualizado.getNome());
		assertEquals("Leonardo@gmail.com", atualizado.getEmail());
	}
	
	@DisplayName("Testando delete Hospede")
	@Test
	void testDeleteHospede() {
		Hospede hospede = new Hospede(null, "Julia maria", "julia@gmail.com", "(00)000-000");
		
		Hospede salvo = hospedeService.salvarHospede(hospede);
		hospedeService.deleteHospede(salvo.getId());
		
		Optional<Hospede> resultado = hospedeService.getHospedeById(salvo.getId());
		
		assertTrue(resultado.isEmpty());
	}
}
