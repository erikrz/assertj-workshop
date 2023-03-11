package com.github.erikrz.pokeapi.dto.movecategory;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Description;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.move.Move;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class MoveCategory implements PokeApiNameResource {

    private final Integer id;
    private final String name;
    private final List<NamedApiResource<Move>> moves;
    private final List<Description> descriptions;

}
