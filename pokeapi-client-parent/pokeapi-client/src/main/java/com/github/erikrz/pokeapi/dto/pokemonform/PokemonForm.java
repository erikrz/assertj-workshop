package com.github.erikrz.pokeapi.dto.pokemonform;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.pokemon.Pokemon;
import com.github.erikrz.pokeapi.dto.versiongroup.VersionGroup;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonForm implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final Integer order;
    private final Integer formOrder;
    private final Boolean isDefault;
    private final Boolean isBattleOnly;
    private final String formName;
    private final NamedApiResource<Pokemon> pokemon;
    private final PokemonFormSprites sprites;
    private final NamedApiResource<VersionGroup> versionGroup;
    private final List<Name> names;
    private final List<Name> formNames;

}
