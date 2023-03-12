package com.github.erikrz.jdk;

import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Sample tests that showcase distinct Map testing methods between JUnit & AssertJ.
 */
@DisplayName("Map tests")
class MapTests {

    private Map<Integer, String> pokemonMap;
    private Map<String, Integer> pokeballMap;

    @BeforeEach
    public void initialize() {
        pokemonMap = Map.of(25, "Pikachu", 282, "Gardevoir", 778, "Mimikyu");
        pokeballMap = Map.of("Regular Ball", 300, "Ultra Ball", 25, "Master Ball", 1);
    }

    @Test
    void testContainsKeysJunit() {
        assertEquals(Set.of(25, 282, 778), pokemonMap.keySet());
    }

    @Test
    void testContainsKeysAssertJ() {
        assertThat(pokemonMap).containsOnlyKeys(25, 282, 778);
    }

    @Test
    void testContainsEntryJUnit() {
        assertTrue(pokeballMap.entrySet().contains(Map.entry("Master Ball", 1)));
    }

    @Test
    void testContainsEntryAssertJ() {
        assertThat(pokeballMap).containsEntry("Master Ball", 1);
    }

    @Test
    void testNotPresentJunit() {
        assertFalse(pokemonMap.containsKey(26));
    }

    @Test
    void testNotPresentAssertJ() {
        assertThat(pokemonMap).doesNotContainKey(26);
    }

    @Test
    void testValueJunit() {
        assertEquals("Mimikyu", pokemonMap.get(778));
    }

    @Test
    void testValueAssertJ() {
        assertThat(pokemonMap).extractingByKey(778).isEqualTo("Mimikyu");
    }

    @Test
    void testSizeAndSortingJUnit() {
        assertTrue(pokemonMap.size() >= 1);
        assertTrue(pokemonMap.size() <= 4);
    }

    @Test
    void testSizeAndSortingAssertJ() {
        assertThat(pokemonMap).hasSizeBetween(1, 4);
    }

}
