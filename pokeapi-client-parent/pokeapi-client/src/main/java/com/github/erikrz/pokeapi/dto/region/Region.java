package com.github.erikrz.pokeapi.dto.region;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.generation.Generation;
import com.github.erikrz.pokeapi.dto.location.Location;
import com.github.erikrz.pokeapi.dto.pokedex.Pokedex;
import com.github.erikrz.pokeapi.dto.versiongroup.VersionGroup;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Region implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final List<NamedApiResource<Location>> locations;
    private final String name;
    private final List<Name> names;
    private final NamedApiResource<Generation> mainGeneration;
    private final List<NamedApiResource<Pokedex>> pokedexes;
    private final List<NamedApiResource<VersionGroup>> versionGroups;

}
