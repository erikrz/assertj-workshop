package com.github.erikrz.pokeapi.dto.supercontesteffect;

import java.util.List;

import com.github.erikrz.pokeapi.dto.FlavorText;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiIdResource;
import com.github.erikrz.pokeapi.dto.move.Move;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class SuperContestEffect implements PokeApiIdResource {

    private final Integer id;
    private final Integer appeal;
    private final List<FlavorText> flavorTextEntries;
    private final List<NamedApiResource<Move>> moves;

}
