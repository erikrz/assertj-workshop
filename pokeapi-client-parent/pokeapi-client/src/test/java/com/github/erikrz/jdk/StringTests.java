package com.github.erikrz.jdk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Sample tests that showcase distinct String testing methods between JUnit & AssertJ.
 */
@DisplayName("String tests")
class StringTests {

    private String pokemonName;
    private String pokemonSlogan;
    private String palletTownPostalCode;

    @BeforeEach
    public void initialize() {
        pokemonName = "Pikachu";
        pokemonSlogan = "Gotta Catch 'Em All";
        palletTownPostalCode = "12345";
    }

    @Test
    void testEqualsJunit() {
        assertEquals("Pikachu", pokemonName);
    }

    @Test
    void testEqualsAssertJ() {
        assertThat(pokemonName).isEqualTo("Pikachu");
    }


    @Test
    void testEqualsIgnoreCaseJunit() {
        assertTrue(pokemonName.equalsIgnoreCase("pikachu"));
    }

    @Test
    void testEqualsIgnoreCaseAssertJ() {
        assertThat(pokemonName).isEqualToIgnoringCase("pikachu");
    }

    @Test
    void testIsBlankJunit() {
        assertFalse(pokemonName.isBlank());
    }

    @Test
    void testIsBlankAssertJ() {
        assertThat(pokemonName).isNotBlank();
    }

    @Test
    void testContainsJunit() {
        assertTrue(pokemonSlogan.startsWith("Gotta"));
        assertTrue(pokemonSlogan.contains("Catch"));
        assertTrue(pokemonSlogan.endsWith("'Em All"));
    }

    @Test
    void testContainsAssertJ() {
        assertThat(pokemonSlogan).startsWith("Gotta").contains("Catch").endsWith("'Em All");
    }

    @Test
    void testPostalCodeJUnit() {
        assertTrue(palletTownPostalCode.matches("[0-9]+"));
        assertEquals(5, palletTownPostalCode.length());
    }

    @Test
    void testPostalCodeAssert() {
        assertThat(palletTownPostalCode).containsOnlyDigits().hasSize(5);
    }
}
