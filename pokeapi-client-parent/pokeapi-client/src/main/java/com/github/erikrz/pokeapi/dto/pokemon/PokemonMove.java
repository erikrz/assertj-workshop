package com.github.erikrz.pokeapi.dto.pokemon;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.move.Move;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonMove {

    private final NamedApiResource<Move> move;
    private final List<PokemonMoveVersion> versionGroupDetails;

}
