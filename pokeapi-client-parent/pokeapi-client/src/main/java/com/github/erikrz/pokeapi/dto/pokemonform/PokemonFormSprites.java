package com.github.erikrz.pokeapi.dto.pokemonform;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class PokemonFormSprites {

    private final String frontDefault;
    private final String frontShiny;
    private final String backDefault;
    private final String backShiny;

}
