package com.github.erikrz.pokeapi.dto.locationarea;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.version.Version;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class EncounterVersionDetails {

    private final Integer rate;
    private final NamedApiResource<Version> version;

}
