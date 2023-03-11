package com.github.erikrz.pokeapi.dto.pokedex;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.pokemonspecies.PokemonSpecies;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonEntry {

    private final Integer entryNumber;
    private final NamedApiResource<PokemonSpecies> pokemonSpecies;

}
