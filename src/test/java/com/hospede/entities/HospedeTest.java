package com.hospede.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HospedeTest {
	
	private Hospede hospede;
	
	@BeforeEach
	void setUp() {
		hospede = new Hospede(1L,"Ronaldo o cego", "ronaldinhodaoba@gmail.com", "(00)0000-0000");
	}

	@Test
	@DisplayName("Teste Id")
	void testId() {
		hospede.setId(2L);
		assertEquals(2L,hospede.getId());
	}
	
	@Test
	@DisplayName("Teste Nome")
	void testNome() {
		hospede.setNome("Jorge e Matheus");
		assertEquals("Jorge e Matheus",hospede.getNome());
	}
	
	@Test
	@DisplayName("Teste Email")
	void testEmail() {
		hospede.setEmail("jonas@gmail.com");
		assertEquals("jonas@gmail.com",hospede.getEmail());
	}
	
	@Test
	@DisplayName("Teste Fone")
	void testFone() {
		hospede.setTelefone("(00)0001-0001");
		assertEquals("(00)0001-0001",hospede.getTelefone());
	}
	
	@Test
	@DisplayName("Teste Construtor")
	void testeConstrutor() {
		Hospede novoHospede = new Hospede(3L,"Matheus o Corredor","matheustherunner@gmail.com","(15)6666-6666");
		assertAll("novoHospede", 
				()-> assertEquals(3L, novoHospede.getId()),
				()-> assertEquals("Matheus o Corredor", novoHospede.getNome()),
				()-> assertEquals("matheustherunner@gmail.com", novoHospede.getEmail()),
				()-> assertEquals("(15)6666-6666", novoHospede.getTelefone())
		);
	}
};
