package com.github.erikrz.pokeapi.dto.gender;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.pokemonspecies.PokemonSpecies;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Gender implements PokeApiNameResource {

    private final Integer id;
    private final String name;
    private final List<PokemonSpeciesGender> pokemonSpeciesDetails;
    private final List<NamedApiResource<PokemonSpecies>> requiredForEvolution;
}
