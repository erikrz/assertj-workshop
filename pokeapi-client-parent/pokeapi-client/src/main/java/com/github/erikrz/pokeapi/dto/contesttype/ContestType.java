package com.github.erikrz.pokeapi.dto.contesttype;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.berryflavor.BerryFlavor;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ContestType implements PokeApiNameResource {

    private final Integer id;
    private final String name;
    private final NamedApiResource<BerryFlavor> berryFlavor;
    private final List<ContestName> names;

}
