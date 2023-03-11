package com.github.erikrz.pokeapi.dto;

import java.util.List;

import com.github.erikrz.pokeapi.dto.version.Version;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class VersionEncounterDetail {

    private final NamedApiResource<Version> version;
    private final Integer maxChance;
    private final List<Encounter> encounterDetails;

}
