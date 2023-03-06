package com.github.erikrz.pokeapi.dto.pokemon;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.version.Version;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonHeldItemVersion {

    private final NamedApiResource<Version> version;
    private final Integer rarity;

}
