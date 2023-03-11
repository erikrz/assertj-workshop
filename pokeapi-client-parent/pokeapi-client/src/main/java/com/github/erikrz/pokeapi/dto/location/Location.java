package com.github.erikrz.pokeapi.dto.location;

import java.util.List;

import com.github.erikrz.pokeapi.dto.GenerationGameIndex;
import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.locationarea.LocationArea;
import com.github.erikrz.pokeapi.dto.region.Region;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Location implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final NamedApiResource<Region> region;
    private final List<Name> names;
    private final List<GenerationGameIndex> gameIndices;
    private final List<NamedApiResource<LocationArea>> areas;

}
