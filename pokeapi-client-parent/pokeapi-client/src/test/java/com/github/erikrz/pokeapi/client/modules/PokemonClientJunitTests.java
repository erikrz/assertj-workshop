package com.github.erikrz.pokeapi.client.modules;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.erikrz.pokeapi.client.PokeApiClientFactory;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.pokemon.PokemonStat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PokemonClientJunitTests {

    private final PokemonClient pokemonClient = (new PokeApiClientFactory()).buildClient(PokemonClient.class);

    @Test
    void testGetPokemonsList() {
        var pokemonsList = pokemonClient.getPokemons(0, 20);

        assertEquals(1281, pokemonsList.getCount());
    }

    @Test
    void testGetPokemonByNumber() {
        var pikachu = pokemonClient.getPokemon(25);

        assertEquals("pikachu", pikachu.getName());
        assertEquals(112, pikachu.getBaseExperience());
        assertEquals(60, pikachu.getWeight());
        assertTrue(pikachu.getStats().contains(
                PokemonStat.builder()
                        .stat(new NamedApiResource<>("hp", "https://pokeapi.co/api/v2/stat/1/"))
                        .baseStat(35)
                        .effort(0).build()));
    }

    @Test
    void testGetPokemonByName() {
        var pikachu = pokemonClient.getPokemon("pikachu");

        assertEquals(25, pikachu.getId());
        assertEquals(112, pikachu.getBaseExperience());
        assertEquals(60, pikachu.getWeight());
        assertTrue(pikachu.getStats().containsAll(List.of(
                PokemonStat.builder()
                        .stat(new NamedApiResource<>("hp", "https://pokeapi.co/api/v2/stat/1/"))
                        .baseStat(35)
                        .effort(0).build(),
                PokemonStat.builder()
                        .stat(new NamedApiResource<>("attack", "https://pokeapi.co/api/v2/stat/2/"))
                        .baseStat(55)
                        .effort(0).build(),
                PokemonStat.builder()
                        .stat(new NamedApiResource<>("defense", "https://pokeapi.co/api/v2/stat/3/"))
                        .baseStat(40)
                        .effort(0).build(),
                PokemonStat.builder()
                        .stat(new NamedApiResource<>("special-attack", "https://pokeapi.co/api/v2/stat/4/"))
                        .baseStat(50)
                        .effort(0).build(),
                PokemonStat.builder()
                        .stat(new NamedApiResource<>("special-defense", "https://pokeapi.co/api/v2/stat/5/"))
                        .baseStat(50)
                        .effort(0).build(),
                PokemonStat.builder()
                        .stat(new NamedApiResource<>("speed", "https://pokeapi.co/api/v2/stat/6/"))
                        .baseStat(90)
                        .effort(2).build()
        ));
    }
}