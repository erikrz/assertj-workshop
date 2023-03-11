package com.github.erikrz.pokeapi.dto.pokemon;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.nature.Nature;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class NaturePokeathlonStatAffect {
    private final Integer id;
    private final NamedApiResource<Nature> language;
}
