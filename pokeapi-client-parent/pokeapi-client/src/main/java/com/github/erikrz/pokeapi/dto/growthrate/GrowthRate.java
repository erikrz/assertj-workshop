package com.github.erikrz.pokeapi.dto.growthrate;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Description;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.pokemonspecies.PokemonSpecies;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class GrowthRate implements PokeApiNameResource {

    private final Integer id;
    private final String name;
    private final String formula;
    private final List<Description> descriptions;
    private final List<GrowthRateExperienceLevel> levels;
    private final List<NamedApiResource<PokemonSpecies>> pokemonSpecies;

}
