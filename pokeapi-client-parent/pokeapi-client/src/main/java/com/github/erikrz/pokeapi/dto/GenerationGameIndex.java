package com.github.erikrz.pokeapi.dto;

import com.github.erikrz.pokeapi.dto.generation.Generation;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class GenerationGameIndex {

    private final Integer gameIndex;
    private final NamedApiResource<Generation> generation;

}
