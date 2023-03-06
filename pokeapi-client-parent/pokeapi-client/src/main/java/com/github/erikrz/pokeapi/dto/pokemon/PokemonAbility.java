package com.github.erikrz.pokeapi.dto.pokemon;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.ability.Ability;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonAbility {
    private Boolean isHidden;
    private Integer slot;
    private NamedApiResource<Ability> ability;
}
