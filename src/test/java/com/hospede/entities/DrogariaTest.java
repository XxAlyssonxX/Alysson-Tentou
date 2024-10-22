package com.hospede.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrogariaTest {

    private Drogaria Drogaria;

    @BeforeEach
    void setUp() {
        Drogaria = new Drogaria(1L, "Ibuprofeno", "6847475887");
    }

    @Test
    @DisplayName("testando o getter e setter do campo ID")
    void testId() {
        // Act
        Drogaria.setId(2L);

        // Assertion
        assertEquals(2L, Drogaria.getId());
    }

    @Test
    @DisplayName("testando o getter e setter do campo nome")
    void testNome() {
        // Act
        Drogaria.setNome("Paracetamol");

        // Assertion
        assertEquals("Paracetamol", Drogaria.getNome());
    }

    @Test
    @DisplayName("testando o getter e setter do campo CNPJ")
    void testCnpj() {
        // Act
        Drogaria.setCnpj("7888778877");

        // Assertion
        assertEquals("7888778877", Drogaria.getCnpj());
    }

    @Test
    @DisplayName("testando o construtor com todos os argumentos")
    void testConstructorAll() {
        // Act
        Drogaria novaDroga = new Drogaria(3L, "Dipirona", "15975348000147");

        // Assertion
        assertAll("novaDroga",
                () -> assertEquals(3L, novaDroga.getId()),
                () -> assertEquals("Dipirona", novaDroga.getNome()),
                () -> assertEquals("15975348000147", novaDroga.getCnpj())
        );
    }
}