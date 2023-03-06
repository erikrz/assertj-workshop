package com.github.erikrz.pokeapi.dto.stat;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class MoveStatAffectSets {

    private final List<MoveStatAffect> increase;
    private final List<MoveStatAffect> decrease;

}
