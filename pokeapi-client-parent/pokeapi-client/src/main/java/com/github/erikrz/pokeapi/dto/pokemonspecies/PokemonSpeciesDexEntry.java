package com.github.erikrz.pokeapi.dto.pokemonspecies;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.pokedex.Pokedex;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonSpeciesDexEntry {

    private final Integer entryNumber;
    private final NamedApiResource<Pokedex> pokedex;

}
