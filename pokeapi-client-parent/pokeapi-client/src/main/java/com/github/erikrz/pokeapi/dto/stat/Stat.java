package com.github.erikrz.pokeapi.dto.stat;

import java.util.List;

import com.github.erikrz.pokeapi.dto.ApiResource;
import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.characteristic.Characteristic;
import com.github.erikrz.pokeapi.dto.movedamageclass.MoveDamageClass;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Stat implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final Integer gameIndex;
    private final Boolean isBattleOnly;
    private final MoveStatAffectSets affectingMoves;
    private final NatureStatAffectSets affectingNatures;
    private final List<ApiResource<Characteristic>> characteristics;
    private final NamedApiResource<MoveDamageClass> moveDamageClass;
    private final List<Name> names;

}
