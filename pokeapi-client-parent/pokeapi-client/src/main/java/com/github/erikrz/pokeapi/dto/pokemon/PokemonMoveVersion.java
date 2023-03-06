package com.github.erikrz.pokeapi.dto.pokemon;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.movelearnmethod.MoveLearnMethod;
import com.github.erikrz.pokeapi.dto.versiongroup.VersionGroup;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonMoveVersion {

    private final NamedApiResource<MoveLearnMethod> moveLearnMethod;
    private final NamedApiResource<VersionGroup> versionGroup;
    private final Integer levelLearnedAt;

}
