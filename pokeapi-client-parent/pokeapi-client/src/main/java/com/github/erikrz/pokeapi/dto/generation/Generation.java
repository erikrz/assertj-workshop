package com.github.erikrz.pokeapi.dto.generation;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.ability.Ability;
import com.github.erikrz.pokeapi.dto.move.Move;
import com.github.erikrz.pokeapi.dto.pokemonspecies.PokemonSpecies;
import com.github.erikrz.pokeapi.dto.type.Type;
import com.github.erikrz.pokeapi.dto.versiongroup.VersionGroup;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Generation implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final List<NamedApiResource<Ability>> abilities;
    private final List<Name> names;
    private final List<NamedApiResource<Move>> moves;
    private final List<NamedApiResource<PokemonSpecies>> pokemonSpecies;
    private final List<NamedApiResource<Type>> types;
    private final List<NamedApiResource<VersionGroup>> versionGroups;

}
