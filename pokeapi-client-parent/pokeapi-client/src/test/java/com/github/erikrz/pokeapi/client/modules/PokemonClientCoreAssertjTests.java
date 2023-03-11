package com.github.erikrz.pokeapi.client.modules;

import org.junit.jupiter.api.Test;

import com.github.erikrz.pokeapi.client.PokeApiClientFactory;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.pokemon.PokemonStat;

import static org.assertj.core.api.Assertions.assertThat;

class PokemonClientCoreAssertjTests {

    private final PokemonClient pokemonClient = (new PokeApiClientFactory()).buildClient(PokemonClient.class);

    @Test
    void testGetPokemonsList() {
        var pokemonsList = pokemonClient.getPokemons(0, 20);
        assertThat(pokemonsList.getCount())
                .isEqualTo(1281);
    }

    @Test
    void testGetPokemonByNumber() {
        var pikachu = pokemonClient.getPokemon(25);
        assertThat(pikachu.getName()).isEqualTo("pikachu");
        assertThat(pikachu.getBaseExperience()).isEqualTo(112);
        assertThat(pikachu.getWeight()).isEqualTo(60);
        assertThat(pikachu.getStats()).contains(
                PokemonStat.builder()
                        .stat(new NamedApiResource<>("hp", "https://pokeapi.co/api/v2/stat/1/"))
                        .baseStat(35)
                        .effort(0).build());
    }

    @Test
    void testGetPokemonByName() {
        var pikachu = pokemonClient.getPokemon("pikachu");
        assertThat(pikachu.getId()).isEqualTo(25);
        assertThat(pikachu.getBaseExperience()).isEqualTo(112);
        assertThat(pikachu.getWeight()).isEqualTo(60);
        assertThat(pikachu.getStats()).containsExactly(
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
        );
    }
}