package com.github.erikrz.pokeapi.dto.pokemon;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.generation.Generation;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonTypePast {

    private final NamedApiResource<Generation> generation;
    private final List<PokemonType> types;
}
