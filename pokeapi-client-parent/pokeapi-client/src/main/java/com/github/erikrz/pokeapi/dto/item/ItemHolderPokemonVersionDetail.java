package com.github.erikrz.pokeapi.dto.item;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.version.Version;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ItemHolderPokemonVersionDetail {

    private final Integer rarity;
    private final NamedApiResource<Version> version;

}
