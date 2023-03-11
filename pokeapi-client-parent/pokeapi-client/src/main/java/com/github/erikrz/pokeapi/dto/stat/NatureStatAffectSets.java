package com.github.erikrz.pokeapi.dto.stat;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.nature.Nature;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class NatureStatAffectSets {

    private final List<NamedApiResource<Nature>> increase;
    private final List<NamedApiResource<Nature>> decrease;

}
