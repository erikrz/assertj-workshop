package com.github.erikrz.pokeapi.dto.type;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class TypeRelations {

    private final List<NamedApiResource<Type>> noDamageTo;
    private final List<NamedApiResource<Type>> halfDamageTo;
    private final List<NamedApiResource<Type>> doubleDamageTo;
    private final List<NamedApiResource<Type>> noDamageFrom;
    private final List<NamedApiResource<Type>> halfDamageFrom;
    private final List<NamedApiResource<Type>> doubleDamageFrom;


}
