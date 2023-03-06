package com.github.erikrz.pokeapi.dto.evolutionchain;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.pokemonspecies.PokemonSpecies;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ChainLink {

    private final Boolean isBaby;
    private final NamedApiResource<PokemonSpecies> species;
    private final List<EvolutionDetail> evolutionDetails;
    private final List<ChainLink> evolvesTo;

}
