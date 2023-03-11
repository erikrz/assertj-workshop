package com.github.erikrz.pokeapi.dto.type;

import java.util.List;

import com.github.erikrz.pokeapi.dto.GenerationGameIndex;
import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.generation.Generation;
import com.github.erikrz.pokeapi.dto.move.Move;
import com.github.erikrz.pokeapi.dto.movedamageclass.MoveDamageClass;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Type implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final TypeRelations damageRelations;
    private final List<TypeRelationsPast> pastDamageRelations;
    private final List<GenerationGameIndex> gameIndices;
    private final NamedApiResource<Generation> generation;
    private final NamedApiResource<MoveDamageClass> moveDamageClass;
    private final List<Name> names;
    private final List<TypePokemon> pokemon;
    private final List<NamedApiResource<Move>> moves;
}
