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
 * Modify the data in the {@link #initialize} method to make the test fail, and see their exception output.
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
    void givenAListOfPokemon_thenItIsEqualTo_withJunit() {
        assertEquals(List.of("Pikachu", "Gardevoir", "Mimikyu"), pokemonList);
    }

    @Test
    void givenAListOfPokemon_thenItIsEqualTo_withAssertJ() {
        assertThat(pokemonList)
                .isEqualTo(List.of("Pikachu", "Gardevoir", "Mimikyu"))
                .containsExactly("Pikachu", "Gardevoir", "Mimikyu");
    }

    @Test
    void givenAListOfPokemon_thenItDoesNotContainsRaichu_withtJunit() {
        assertFalse(pokemonList.contains("Raichu"));
    }

    @Test
    void givenAListOfPokemon_testNotPresent_withAssertJ() {
        assertThat(pokemonList).doesNotContain("Raichu");
    }

    @Test
    void givenAListOfPokemon_testIsBlank_withtJunit() {
        assertFalse(pokemonList.isEmpty());
    }

    @Test
    void givenAListOfPokemon_testIsBlank_withAssertJ() {
        assertThat(pokemonList).isNotEmpty();
    }

    @Test
    void givenAListOfPokemonDollars_testSizeAndSorting_withtJunit() {
        assertEquals(3, pokemonDollars.size());
        assertEquals(pokemonDollars.stream().sorted().collect(toList()), pokemonDollars);
    }

    @Test
    void givenAListOfPokemonDollars_testSizeAndSorting_withAssertJ() {
        assertThat(pokemonDollars).hasSize(3).isSorted();
    }
}
