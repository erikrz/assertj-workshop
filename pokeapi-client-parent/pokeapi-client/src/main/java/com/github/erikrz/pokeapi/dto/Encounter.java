package com.github.erikrz.pokeapi.dto;

import java.util.List;

import com.github.erikrz.pokeapi.dto.encounterconditionvalue.EncounterConditionValue;
import com.github.erikrz.pokeapi.dto.encountermethod.EncounterMethod;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Encounter {

    private final Integer minLevel;
    private final Integer maxLevel;
    private final List<NamedApiResource<EncounterConditionValue>> conditionValues;
    private final Integer chance;
    private final NamedApiResource<EncounterMethod> method;

}
