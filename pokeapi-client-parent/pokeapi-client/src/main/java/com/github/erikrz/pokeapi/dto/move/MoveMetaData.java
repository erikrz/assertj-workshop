package com.github.erikrz.pokeapi.dto.move;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.moveailment.MoveAilment;
import com.github.erikrz.pokeapi.dto.movecategory.MoveCategory;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class MoveMetaData {

    private final NamedApiResource<MoveAilment> ailment;
    private final NamedApiResource<MoveCategory> category;
    private final Integer minHits;
    private final Integer maxHits;
    private final Integer minTurns;
    private final Integer maxTurns;
    private final Integer drain;
    private final Integer healing;
    private final Integer critRate;
    private final Integer ailmentChance;
    private final Integer flinchChance;
    private final Integer statChance;

}
