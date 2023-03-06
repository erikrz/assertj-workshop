package com.github.erikrz.pokeapi.dto.pokemon;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.item.Item;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonHeldItem {

    private final NamedApiResource<Item> item;
    private final List<PokemonHeldItemVersion> versionDetails;

}
