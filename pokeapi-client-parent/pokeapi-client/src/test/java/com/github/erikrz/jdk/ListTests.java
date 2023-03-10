package com.github.erikrz.jdk;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


/**
 * Sample tests that showcase distinct List testing methods between JUnit & AssertJ.
 */
@DisplayName("List tests")
class ListTests {

    private List<String> pokemonList;
    private List<Integer> pokemonDollars;

    @BeforeEach
    public void initialize() {
        pokemonList = List.of("Pikachu", "Gardevoir", "Mimikyu");
        pokemonDollars = List.of(50, 100, 200);
    }

    @Test
    void testEqualsJunit() {
        assertEquals(List.of("Pikachu", "Gardevoir", "Mimikyu"), pokemonList);
    }

    @Test
    void testEqualsAssertJ() {
        assertThat(pokemonList)
                .isEqualTo(List.of("Pikachu", "Gardevoir", "Mimikyu"))
                .containsExactly("Pikachu", "Gardevoir", "Mimikyu");
    }

    @Test
    void testNotPresentJunit() {
        assertFalse(pokemonList.contains("Raichu"));
    }

    @Test
    void testNotPresentAssertJ() {
        assertThat(pokemonList).doesNotContain("Raichu");
    }

    @Test
    void testIsBlankJunit() {
        assertFalse(pokemonList.isEmpty());
    }

    @Test
    void testIsBlankAssertJ() {
        assertThat(pokemonList).isNotEmpty();
    }

    @Test
    void testSizeAndSortingJUnit() {
        assertEquals(3, pokemonDollars.size());
        assertEquals(pokemonDollars.stream().sorted().collect(toList()), pokemonDollars);
    }

    @Test
    void testSizeAndSortingAssertJ() {
        assertThat(pokemonDollars).hasSize(3).isSorted();
    }
}
