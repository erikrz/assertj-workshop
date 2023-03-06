package com.github.erikrz.pokeapi.dto;

import com.github.erikrz.pokeapi.dto.language.Language;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Description {

    private final String description;
    private final NamedApiResource<Language> language;
}
