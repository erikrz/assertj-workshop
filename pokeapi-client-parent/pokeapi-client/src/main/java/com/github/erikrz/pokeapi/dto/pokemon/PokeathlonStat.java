package com.github.erikrz.pokeapi.dto.pokemon;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokeathlonStat implements PokeApiNameResource {
    private final Integer id;
    private final String name;
    private final List<Name> names;
    private final NaturePokeathlonStatAffectSets affectingNatures;
}
