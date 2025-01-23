package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;


    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void add() {
        assertEquals(8, calculator.add(3,5));
        assertNotEquals(8, calculator.add(3,4));
    }

    @Test
    void subtract() {
        assertEquals(-8, calculator.subtract(10, 18));
        assertNotEquals(10, calculator.subtract(2,3) );
    }

    @Test
    void divide()  {
        try {
            assertEquals(5, calculator.divide(20, 4));
        } catch (DivideByZeroException e) {
            throw new RuntimeException();
        }

        try {
            assertNotEquals(3, calculator.divide(4,1));
        } catch (DivideByZeroException e) {
            throw new RuntimeException();
        }

        assertThrows(DivideByZeroException.class, () -> calculator.divide(12, 0));
    }

    @Test
    void multiply() {
        assertEquals(12, calculator.multiply(3,4));
        assertNotEquals(12, calculator.multiply(3,3));
    }

    @Test
    void calculateSquareRoot_PositiveNumber() {
        assertEquals(4.0, calculator.calculateSquareRoot(16.0), 0.0001, "The square root of 16 should be 4");
    }

    @Test
    void calculateSquareRoot_Zero() {
        assertEquals(0.0, calculator.calculateSquareRoot(0.0), 0.0001, "The square root of 0 should be 0");
    }

    @Test
    void calculateSquareRoot_NegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateSquareRoot(-1.0),
                "Calculating the square root of a negative number should throw an exception");
    }
    @Test
    void testSquare() {
        assertEquals(16, calculator.square(4));
        assertEquals(0, calculator.square(0));
        assertEquals(1, calculator.square(1));
    }


}