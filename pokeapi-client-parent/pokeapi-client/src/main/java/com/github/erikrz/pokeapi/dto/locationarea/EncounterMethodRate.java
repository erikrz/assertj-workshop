package com.github.erikrz.pokeapi.dto.locationarea;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.encountermethod.EncounterMethod;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class EncounterMethodRate {

    private final NamedApiResource<EncounterMethod> encounterMethod;
    private final List<EncounterVersionDetails> versionDetails;

}
