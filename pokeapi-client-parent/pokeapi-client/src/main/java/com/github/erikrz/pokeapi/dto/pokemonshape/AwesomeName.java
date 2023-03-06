package com.github.erikrz.pokeapi.dto.pokemonshape;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.language.Language;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class AwesomeName {

    private final String awesomeName;
    private final NamedApiResource<Language> language;

}
