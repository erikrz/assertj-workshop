package com.github.erikrz.pokeapi.dto.berry;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.berryflavor.BerryFlavor;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class BerryFlavorMap {

    private final Integer potency;
    private final NamedApiResource<BerryFlavor> flavor;

}
