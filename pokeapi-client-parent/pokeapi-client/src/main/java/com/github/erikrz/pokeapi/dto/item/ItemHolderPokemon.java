package com.github.erikrz.pokeapi.dto.item;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.pokemon.Pokemon;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ItemHolderPokemon {

    private final NamedApiResource<Pokemon> pokemon;
    private final List<ItemHolderPokemonVersionDetail> versionDetails;

}
