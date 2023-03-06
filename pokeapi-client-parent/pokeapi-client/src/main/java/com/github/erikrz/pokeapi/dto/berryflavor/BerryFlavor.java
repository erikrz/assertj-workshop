package com.github.erikrz.pokeapi.dto.berryflavor;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.contesttype.ContestType;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;


@Data
@Jacksonized
@Builder(toBuilder = true)
public class BerryFlavor implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final List<FlavorBerryMap> barries;
    private final NamedApiResource<ContestType> contestType;
    private final List<Name> names;

}
