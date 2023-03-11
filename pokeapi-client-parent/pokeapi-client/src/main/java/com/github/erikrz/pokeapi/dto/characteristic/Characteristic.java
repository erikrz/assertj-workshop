package com.github.erikrz.pokeapi.dto.characteristic;

import java.util.List;

import com.github.erikrz.pokeapi.dto.PokeApiIdResource;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Characteristic implements PokeApiIdResource {

    private final Integer id;
    private final Integer geneModulo;
    private final List<Integer> possibleValues;

}
