package com.github.erikrz.pokeapi.client.modules;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.erikrz.pokeapi.client.PokeApiClientFactory;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.pokemon.PokemonStat;

import feign.FeignException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Pokemon Client Tests with JUnit")
class PokemonClientJunitTests {

    private final PokemonClient pokemonClient = (new PokeApiClientFactory()).buildClient(PokemonClient.class);

    @Test
    void givenAPokemonClient_whenGettingPokemons_thenCountIs1281() {
        var pokemonsList = pokemonClient.getPokemons(0, 20);

        assertEquals(1281, pokemonsList.getCount());
    }

    @Test
    void givenAPokemonClient_whenGettingPokemonNumberMinus1_thenException() {
        var thrown = assertThrows(FeignException.NotFound.class, () -> pokemonClient.getPokemon(-1),
                "FeignException.NotFound error was expected");

        assertEquals(
                "[404 Not Found] during [GET] to [https://pokeapi.co/api/v2/pokemon/-1] [PokemonClient#getPokemon(Integer)]: [Not Found]",
                thrown.getMessage());

    }

    @Test
    void givenAPokemonClient_whenGettingPokemonNumber25_thenExpectPikachu() {
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
    void givenAPokemonClient_whenGettingPokemonNamedPikachu_thenExpectPokemonNumber25() {
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
        )));
    }
}