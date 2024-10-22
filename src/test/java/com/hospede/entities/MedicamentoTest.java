package com.hospede.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MedicamentoTest {
	
	private Medicamento medicamento;
	
	@BeforeEach
	void setUp() {
		medicamento = new Medicamento(1L,"alysson", "remédio de bronquite", "12/02/1022");
	}

	@Test
	@DisplayName("Teste Id")
	void testId() {
		medicamento.setId(2L);
		assertEquals(2L,medicamento.getId());
	}
	
	@Test
	@DisplayName("Teste Nome")
	void testNome() {
		medicamento.setNome("Jorge e Matheus");
		assertEquals("Jorge e Matheus",medicamento.getNome());
	}
	
	@Test
	@DisplayName("Teste Bula")
	void testBula() {
		medicamento.setBula("remedio de paleolite");
		assertEquals("remedio de paleolite",medicamento.getBula());
	}
	
	@Test
	@DisplayName("Teste dataValidade")
	void testData() {
		medicamento.setDataValidade("11/09/2001");
		assertEquals("11/09/2001",medicamento.getDataValidade());
	}
	
	@Test
	@DisplayName("Teste Construtor")
	void testeConstrutor() {
		Medicamento novomedicamento = new Medicamento(3L,"matheus","remedio de tdah","10/10/2010");
		assertAll("novoMedicamento", 
				()-> assertEquals(3L, novomedicamento.getId()),
				()-> assertEquals("matheus", novomedicamento.getNome()),
				()-> assertEquals("remedio de tdah", novomedicamento.getBula()),
				()-> assertEquals("10/10/2010", novomedicamento.getDataValidade())
		);
	}
};
