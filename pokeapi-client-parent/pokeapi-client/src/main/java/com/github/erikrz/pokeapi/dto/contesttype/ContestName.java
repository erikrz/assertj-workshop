package com.github.erikrz.pokeapi.dto.contesttype;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.language.Language;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ContestName {

    private final String name;
    private final String color;
    private final NamedApiResource<Language> language;


}
