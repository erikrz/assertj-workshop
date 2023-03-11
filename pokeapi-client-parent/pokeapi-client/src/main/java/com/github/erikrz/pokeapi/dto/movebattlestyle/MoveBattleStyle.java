package com.github.erikrz.pokeapi.dto.movebattlestyle;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.move.Move;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class MoveBattleStyle implements PokeApiNameResource {

    private final Integer id;
    private final String name;
    private final List<NamedApiResource<Move>> moves;
}
