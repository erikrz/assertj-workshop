package com.github.erikrz.pokeapi.dto.berryflavor;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.berry.Berry;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class FlavorBerryMap {

    private final Integer potency;
    private final NamedApiResource<Berry> berry;

}
