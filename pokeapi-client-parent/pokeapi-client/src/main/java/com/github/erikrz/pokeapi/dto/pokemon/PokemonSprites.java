package com.github.erikrz.pokeapi.dto.pokemon;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonSprites {

    private final String frontDefault;
    private final String frontShiny;
    private final String frontFemale;
    private final String frontShinyFemale;
    private final String backDefault;
    private final String backShiny;
    private final String backFemale;
    private final String backShinyFemale;
}
