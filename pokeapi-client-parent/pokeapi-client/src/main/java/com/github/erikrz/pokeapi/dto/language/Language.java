package com.github.erikrz.pokeapi.dto.language;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Language implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final Boolean official;
    private final String iso639;
    private final String iso3166;
    private final List<Name> names;

}
