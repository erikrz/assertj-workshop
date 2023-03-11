package com.github.erikrz.pokeapi.dto;

import com.github.erikrz.pokeapi.dto.language.Language;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Effect {

    private final String effect;
    private final NamedApiResource<Language> language;

}
