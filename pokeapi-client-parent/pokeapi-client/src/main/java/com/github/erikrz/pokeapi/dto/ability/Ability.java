package com.github.erikrz.pokeapi.dto.ability;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiIdResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.VerboseEffect;
import com.github.erikrz.pokeapi.dto.generation.Generation;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Ability implements PokeApiIdResource, PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final Boolean isMainSeries;
    private final NamedApiResource<Generation> generation;
    private final List<Name> names;
    private final List<VerboseEffect> effectEntries;
    private final List<AbilityEffectChange> effectChanges;
    private final List<AbilityFlavorText> flavorTextEntries;
    private final List<AbilityPokemon> pokemon;


}
