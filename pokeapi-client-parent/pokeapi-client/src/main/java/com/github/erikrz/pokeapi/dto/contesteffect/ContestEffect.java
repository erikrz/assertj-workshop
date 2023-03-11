package com.github.erikrz.pokeapi.dto.contesteffect;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Effect;
import com.github.erikrz.pokeapi.dto.FlavorText;
import com.github.erikrz.pokeapi.dto.PokeApiIdResource;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ContestEffect implements PokeApiIdResource {

    private final Integer id;
    private final Integer appeal;
    private final Integer jam;
    private final List<Effect> effectEntries;
    private final List<FlavorText> flavorTextEntries;

}
