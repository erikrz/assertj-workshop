package com.github.erikrz.pokeapi.dto.type;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.pokemon.Pokemon;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class TypePokemon {

    private final Integer slot;
    private final NamedApiResource<Pokemon> pokemon;
}
