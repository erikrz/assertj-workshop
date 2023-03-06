package com.github.erikrz.pokeapi.dto.stat;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.move.Move;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class MoveStatAffect {

    private final Integer change;
    private final NamedApiResource<Move> move;

}
