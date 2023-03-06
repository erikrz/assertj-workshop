package com.github.erikrz.pokeapi.dto.ability;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Effect;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.versiongroup.VersionGroup;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class AbilityEffectChange {

    private final List<Effect> effectEntries;
    private final NamedApiResource<VersionGroup> versionGroup;

}
