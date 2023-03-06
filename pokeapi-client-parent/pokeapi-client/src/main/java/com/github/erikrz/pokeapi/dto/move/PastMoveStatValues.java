package com.github.erikrz.pokeapi.dto.move;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.VerboseEffect;
import com.github.erikrz.pokeapi.dto.type.Type;
import com.github.erikrz.pokeapi.dto.versiongroup.VersionGroup;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PastMoveStatValues {

    private final Integer accuracy;
    private final Integer effectChance;
    private final Integer power;
    private final Integer pp;
    private final List<VerboseEffect> effectEntries;
    private final NamedApiResource<Type> type;
    private final NamedApiResource<VersionGroup> versionGroup;

}
