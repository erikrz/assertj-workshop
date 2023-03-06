package com.github.erikrz.pokeapi.dto.nature;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.berryflavor.BerryFlavor;
import com.github.erikrz.pokeapi.dto.stat.Stat;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Nature implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final NamedApiResource<Stat> decreasedStat;
    private final NamedApiResource<Stat> increasedStat;
    private final NamedApiResource<BerryFlavor> hatesFlavor;
    private final NamedApiResource<BerryFlavor> likesFlavor;
    private final List<Name> names;

}
