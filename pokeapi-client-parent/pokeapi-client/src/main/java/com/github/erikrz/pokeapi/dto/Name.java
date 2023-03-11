package com.github.erikrz.pokeapi.dto;


import com.github.erikrz.pokeapi.dto.language.Language;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Name {

    private final String name;
    private final NamedApiResource<Language> language;

}
