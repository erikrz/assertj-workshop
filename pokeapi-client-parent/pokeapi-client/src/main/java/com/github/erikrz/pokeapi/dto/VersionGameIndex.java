package com.github.erikrz.pokeapi.dto;

import com.github.erikrz.pokeapi.dto.version.Version;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class VersionGameIndex {

    private final Integer gameIndex;
    private final NamedApiResource<Version> version;


}
