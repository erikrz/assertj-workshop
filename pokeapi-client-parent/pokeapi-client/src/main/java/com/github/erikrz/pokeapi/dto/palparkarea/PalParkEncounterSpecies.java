package com.github.erikrz.pokeapi.dto.palparkarea;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.pokemonspecies.PokemonSpecies;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PalParkEncounterSpecies {
    private final Integer baseScore;
    private final Integer rate;
    private final NamedApiResource<PokemonSpecies> pokemonSpecies;
}
