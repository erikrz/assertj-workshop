package com.github.erikrz.pokeapi.dto.move;

import java.util.List;

import com.github.erikrz.pokeapi.dto.ApiResource;
import com.github.erikrz.pokeapi.dto.MachineVersionDetail;
import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.VerboseEffect;
import com.github.erikrz.pokeapi.dto.ability.AbilityEffectChange;
import com.github.erikrz.pokeapi.dto.contesteffect.ContestEffect;
import com.github.erikrz.pokeapi.dto.contesttype.ContestType;
import com.github.erikrz.pokeapi.dto.generation.Generation;
import com.github.erikrz.pokeapi.dto.movedamageclass.MoveDamageClass;
import com.github.erikrz.pokeapi.dto.movetarget.MoveTarget;
import com.github.erikrz.pokeapi.dto.supercontesteffect.SuperContestEffect;
import com.github.erikrz.pokeapi.dto.type.Type;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Move implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final Integer accuracy;
    private final Integer effectChance;
    private final Integer pp;
    private final Integer priority;
    private final Integer power;
    private final ContestComboSets contestCombos;
    private final NamedApiResource<ContestType> contestType;
    private final ApiResource<ContestEffect> contestEffect;
    private final NamedApiResource<MoveDamageClass> damageClass;
    private final List<VerboseEffect> effectEntries;
    private final List<AbilityEffectChange> effectChanges;
    private final List<MoveFlavorText> flavorTextEntries;
    private final NamedApiResource<Generation> generation;
    private final List<MachineVersionDetail> machines;
    private final MoveMetaData meta;
    private final List<Name> names;
    private final List<PastMoveStatValues> pastValues;
    private final List<MoveStatChange> statChanges;
    private final ApiResource<SuperContestEffect> superContestEffect;
    private final NamedApiResource<MoveTarget> target;
    private final NamedApiResource<Type> type;

}
