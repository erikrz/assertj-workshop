package com.github.erikrz.pokeapi.dto.pokemonspecies;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.language.Language;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Genus {

    private final String genus;
    private final NamedApiResource<Language> language;

}
