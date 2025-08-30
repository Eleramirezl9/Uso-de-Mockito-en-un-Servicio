package com.grupo6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@DisplayName("Calculadora Tests")
public class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Prueba de suma")
    void testSumar() {
        assertEquals(5, calculadora.sumar(2, 3));
        assertEquals(0, calculadora.sumar(-1, 1));
        assertEquals(-2, calculadora.sumar(-1, -1));
    }

    @Test
    @DisplayName("Prueba de resta")
    void testRestar() {
        assertEquals(1, calculadora.restar(3, 2));
        assertEquals(-1, calculadora.restar(2, 3));
        assertEquals(0, calculadora.restar(5, 5));
    }

    @Test
    @DisplayName("Prueba de multiplicación")
    void testMultiplicar() {
        assertEquals(6, calculadora.multiplicar(2, 3));
        assertEquals(0, calculadora.multiplicar(0, 5));
        assertEquals(-10, calculadora.multiplicar(-2, 5));
    }

    @Test
    @DisplayName("Prueba de división")
    void testDividir() {
        assertEquals(2.0, calculadora.dividir(6, 3), 0.001);
        assertEquals(-2.5, calculadora.dividir(5, -2), 0.001);
        assertEquals(0.0, calculadora.dividir(0, 5), 0.001);
    }

    @Test
    @DisplayName("División por cero debe lanzar excepción")
    void testDivisionPorCero() {
        ArithmeticException exception = assertThrows(
            ArithmeticException.class,
            () -> calculadora.dividir(10, 0)
        );
        assertTrue(exception.getMessage().contains("No se puede dividir por cero"));
    }
}