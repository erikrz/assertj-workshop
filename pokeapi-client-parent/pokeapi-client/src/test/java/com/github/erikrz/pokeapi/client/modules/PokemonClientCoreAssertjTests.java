package com.github.erikrz.pokeapi.client.modules;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.erikrz.pokeapi.client.PokeApiClientFactory;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.pokemon.PokemonStat;

import feign.FeignException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DisplayName("Pokemon Client Tests with Core AssertJ")
class PokemonClientCoreAssertjTests {

    private final PokemonClient pokemonClient = (new PokeApiClientFactory()).buildClient(PokemonClient.class);

    @Test
    void givenAPokemonClient_whenGettingPokemons_thenCountIs1281() {
        var pokemonsList = pokemonClient.getPokemons(0, 20);
        assertThat(pokemonsList.getCount())
                .isEqualTo(1281);
    }

    @Test
    void givenAPokemonClient_whenGettingPokemonNumberMinus1_thenException() {
        var throwable = catchThrowable(() -> pokemonClient.getPokemon(-1));

        assertThat(throwable)
                .isInstanceOf(FeignException.NotFound.class)
                .hasMessage(
                        "[404 Not Found] during [GET] to [https://pokeapi.co/api/v2/pokemon/-1] [PokemonClient#getPokemon(Integer)]: [Not Found]");
    }

    @Test
    void givenAPokemonClient_whenGettingPokemonNumber25_thenExpectPikachu() {
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
    void givenAPokemonClient_whenGettingPokemonNamedPikachu_thenExpectPokemonNumber25() {
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