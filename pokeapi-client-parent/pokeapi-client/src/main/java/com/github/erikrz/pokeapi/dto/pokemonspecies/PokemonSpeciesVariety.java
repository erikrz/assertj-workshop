package com.github.erikrz.pokeapi.dto.pokemonspecies;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.pokemon.Pokemon;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonSpeciesVariety {

    private final Boolean isDefault;
    private final NamedApiResource<Pokemon> pokemon;

}
