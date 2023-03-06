package com.github.erikrz.pokeapi.dto.encountermethod;

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
public class EncounterMethod implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final Integer order;
    private final List<Name> names;

}
