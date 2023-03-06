package com.github.erikrz.pokeapi.dto.pokemonspecies;

import java.util.List;

import com.github.erikrz.pokeapi.dto.ApiResource;
import com.github.erikrz.pokeapi.dto.Description;
import com.github.erikrz.pokeapi.dto.FlavorText;
import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.egggroup.EggGroup;
import com.github.erikrz.pokeapi.dto.evolutionchain.EvolutionChain;
import com.github.erikrz.pokeapi.dto.generation.Generation;
import com.github.erikrz.pokeapi.dto.growthrate.GrowthRate;
import com.github.erikrz.pokeapi.dto.pokemoncolor.PokemonColor;
import com.github.erikrz.pokeapi.dto.pokemonhabitat.PokemonHabitat;
import com.github.erikrz.pokeapi.dto.pokemonshape.PokemonShape;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonSpecies implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final Integer order;
    private final Integer genderRate;
    private final Integer captureRate;
    private final Integer baseHappiness;
    private final Boolean isBaby;
    private final Boolean isLegendary;
    private final Boolean isMythical;
    private final Integer hatchCounter;
    private final Boolean hasGenderDifferences;
    private final Boolean formsSwitchable;
    private final NamedApiResource<GrowthRate> growthRate;
    private final List<PokemonSpeciesDexEntry> pokedexNumbers;
    private final List<NamedApiResource<EggGroup>> eggGroups;
    private final NamedApiResource<PokemonColor> color;
    private final NamedApiResource<PokemonShape> shape;
    private final NamedApiResource<PokemonSpecies> evolvesFromSpecies;
    private final ApiResource<EvolutionChain> evolutionChain;
    private final NamedApiResource<PokemonHabitat> habitat;
    private final NamedApiResource<Generation> generation;
    private final List<Name> names;
    private final List<FlavorText> flavorTextEntries;
    private final List<Description> formDescriptions;
    private final List<Genus> genera;
    private final List<PokemonSpeciesVariety> varieties;

}
