package com.github.erikrz.pokeapi.dto.move;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ContestComboDetail {

    private final List<NamedApiResource<Move>> userBefore;
    private final List<NamedApiResource<Move>> userAfter;

}
