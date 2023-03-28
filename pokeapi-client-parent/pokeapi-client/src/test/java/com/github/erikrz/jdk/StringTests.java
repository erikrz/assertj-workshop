package com.github.erikrz.jdk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Sample tests that showcase distinct String testing methods between JUnit & AssertJ.
 * Modify the data in the {@link #initialize} method to make the test fail, and see their exception output.
 */
@DisplayName("String tests")
class StringTests {

    private String pokemonName;
    private String pokemonSlogan;
    private String palletTownPostalCode;

    @BeforeEach
    public void initialize() {
        pokemonName = "Teddiursa";
        pokemonSlogan = "Gotta Catch 'Em All";
        palletTownPostalCode = "12345";
    }

    @Test
    void givenAPokemonName_thenItShouldBeEqualsToTeddiursa_withJunit() {
        assertEquals("Teddiursa", pokemonName);
    }

    @Test
    void givenAPokemonName_thenItShouldBeEqualsToTeddiursa_withAssertJ() {
        assertThat(pokemonName).isEqualTo("Teddiursa");
    }


    @Test
    void givenAPokemonName_thenItShouldBeEqualsToTeddiursaIgnoringCase_withJunit() {
        assertTrue(pokemonName.equalsIgnoreCase("teddiursa"),
                "pokemonName should be equal to 'teddiursa' ignoring case");
    }

    @Test
    void givenAPokemonName_thenItShouldBeEqualsToTeddiursaIgnoringCase_withAssertJ() {
        assertThat(pokemonName).isEqualToIgnoringCase("teddiursa");
    }

    @Test
    void givenAPokemonName_thenItShouldNotBeBlank_withJunit() {
        assertFalse(pokemonName.isBlank(), "pokemonName should not be blank");
    }

    @Test
    void givenAPokemonName_thenItShouldNotBeBlank_withAssertJ() {
        assertThat(pokemonName).isNotBlank();
    }

    @Test
    void givenThePokemonSlogan_thenItContainsTheCorrectWords_withJunit() {
        assertTrue(pokemonSlogan.startsWith("Gotta"), format("'%s' should start with: 'Gotta'", pokemonSlogan));
        assertTrue(pokemonSlogan.contains("Catch"), format("'%s' should contain: 'Catch'", pokemonSlogan));
        assertTrue(pokemonSlogan.endsWith("'Em All"), format("'%s' should end with: ''Em All'", pokemonSlogan));
    }

    @Test
    void givenThePokemonSlogan_thenItContainsTheCorrectWords_withAssertJ() {
        assertThat(pokemonSlogan)
                .startsWith("Gotta")
                .contains("Catch")
                .endsWith("'Em All");
    }

    @Test
    void givenAPostalCode_thenItContainsDigitsOnly_withJunit() {
        assertTrue(palletTownPostalCode.matches("[0-9]+"),
                format("'%s' should contain digits only", palletTownPostalCode));
        assertEquals(5, palletTownPostalCode.length(),
                format("'%s' should have exactly 5 digits", palletTownPostalCode));
    }

    @Test
    void givenAPostalCode_thenItContainsDigitsOnly_withAssertJ() {
        assertThat(palletTownPostalCode).containsOnlyDigits().hasSize(5);
    }
}
