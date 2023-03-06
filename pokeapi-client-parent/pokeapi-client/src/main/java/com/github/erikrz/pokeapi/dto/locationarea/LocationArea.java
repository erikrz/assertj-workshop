package com.github.erikrz.pokeapi.dto.locationarea;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.location.Location;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class LocationArea implements PokeApiNameResource, Localizable {

    private final Integer Id;
    private final String name;
    private final Integer gameIndex;
    private final List<EncounterMethodRate> encoutnerMethodRates;
    private final NamedApiResource<Location> location;
    private final List<Name> names;
    private final List<PokemonEncounter> pokemonEncounters;

}
