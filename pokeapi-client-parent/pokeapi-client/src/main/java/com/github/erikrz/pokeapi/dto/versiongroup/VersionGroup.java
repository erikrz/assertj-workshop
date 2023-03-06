package com.github.erikrz.pokeapi.dto.versiongroup;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.generation.Generation;
import com.github.erikrz.pokeapi.dto.movelearnmethod.MoveLearnMethod;
import com.github.erikrz.pokeapi.dto.pokedex.Pokedex;
import com.github.erikrz.pokeapi.dto.region.Region;
import com.github.erikrz.pokeapi.dto.version.Version;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class VersionGroup implements PokeApiNameResource {

    private final Integer id;
    private final String name;
    private final Integer order;
    private final NamedApiResource<Generation> generation;
    private final List<NamedApiResource<MoveLearnMethod>> moveLearnMethods;
    private final List<NamedApiResource<Pokedex>> pokedexes;
    private final List<NamedApiResource<Region>> regions;
    private final List<NamedApiResource<Version>> versions;

}
