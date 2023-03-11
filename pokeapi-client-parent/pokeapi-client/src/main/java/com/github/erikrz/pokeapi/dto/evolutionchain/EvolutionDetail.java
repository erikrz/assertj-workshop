package com.github.erikrz.pokeapi.dto.evolutionchain;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.evolutiontrigger.EvolutionTrigger;
import com.github.erikrz.pokeapi.dto.item.Item;
import com.github.erikrz.pokeapi.dto.location.Location;
import com.github.erikrz.pokeapi.dto.move.Move;
import com.github.erikrz.pokeapi.dto.pokemonspecies.PokemonSpecies;
import com.github.erikrz.pokeapi.dto.type.Type;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class EvolutionDetail {

    private final NamedApiResource<Item> item;
    private final NamedApiResource<EvolutionTrigger> trigger;
    private final Integer gender;
    private final NamedApiResource<Item> heldItem;
    private final NamedApiResource<Move> knownMove;
    private final NamedApiResource<Type> knownMoveType;
    private final NamedApiResource<Location> location;
    private final Integer minLevel;
    private final Integer minHappiness;
    private final Integer minBeauty;
    private final Integer minAffection;
    private final Boolean needsOverworldRain;
    private final NamedApiResource<PokemonSpecies> partySpecies;
    private final NamedApiResource<Type> partyType;
    private final Integer relativePhysicalStats;
    private final String timeOfDay;
    private final NamedApiResource<PokemonSpecies> tradeSpecies;
    private final Boolean turnUpsideDown;

}
