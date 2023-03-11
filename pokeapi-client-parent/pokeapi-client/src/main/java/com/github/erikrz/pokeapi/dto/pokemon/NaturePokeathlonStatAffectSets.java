package com.github.erikrz.pokeapi.dto.pokemon;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class NaturePokeathlonStatAffectSets {
    private final List<NaturePokeathlonStatAffect> increase;
    private final List<NaturePokeathlonStatAffect> decrease;
}
