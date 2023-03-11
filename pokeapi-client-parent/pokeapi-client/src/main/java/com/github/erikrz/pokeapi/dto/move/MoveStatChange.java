package com.github.erikrz.pokeapi.dto.move;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.stat.Stat;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class MoveStatChange {

    private final Integer change;
    private final NamedApiResource<Stat> stat;

}
