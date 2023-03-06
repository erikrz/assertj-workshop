package com.github.erikrz.pokeapi.dto.pokemon;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.type.Type;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonType {

    private final Integer slot;
    private final NamedApiResource<Type> type;

}
