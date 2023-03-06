package com.github.erikrz.pokeapi.dto.move;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ContestComboSets {

    private final ContestComboDetail normal;
    @JsonProperty("super")
    private final ContestComboDetail superb;
}
