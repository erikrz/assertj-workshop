package com.github.erikrz.pokeapi.dto;

import com.github.erikrz.pokeapi.dto.language.Language;
import com.github.erikrz.pokeapi.dto.version.Version;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class FlavorText {

    private final String flavorText;
    private final NamedApiResource<Language> language;
    private final NamedApiResource<Version> version;


}
