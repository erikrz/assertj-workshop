package com.github.erikrz.pokeapi.dto.pokemon;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.VersionGameIndex;
import com.github.erikrz.pokeapi.dto.pokemonform.PokemonForm;
import com.github.erikrz.pokeapi.dto.pokemonspecies.PokemonSpecies;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Pokemon implements PokeApiNameResource {
    private final Integer id;
    private final String name;
    private final Integer baseExperience;
    private final Integer height;
    private final Boolean isDefault;
    private final Integer order;
    private final Integer weight;
    private final List<PokemonAbility> abilities;
    private final List<NamedApiResource<PokemonForm>> forms;
    private final List<VersionGameIndex> gameIndices;
    private final List<PokemonHeldItem> heldItems;
    private final String locationAreaEncounters;
    private final List<PokemonMove> moves;
    private final PokemonSprites sprites;
    private final NamedApiResource<PokemonSpecies> species;
    private final List<PokemonStat> stats;
    private final List<PokemonType> types;
    private final List<PokemonTypePast> pastTypes;

}
