package test;

import main.java.vegeCrash.utils.RandomGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {

    @Test
    void shouldReturnZero() {
        assertEquals(0, RandomGenerator.generateRandomIntValue(1));
    }

    @Test
    void shouldReturnException() {
        assertThrows(IllegalArgumentException.class, () -> RandomGenerator.generateRandomIntValue(-5));
    }
}