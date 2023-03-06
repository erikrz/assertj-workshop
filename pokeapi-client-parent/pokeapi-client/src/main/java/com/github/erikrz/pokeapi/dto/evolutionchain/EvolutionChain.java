package com.github.erikrz.pokeapi.dto.evolutionchain;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiIdResource;
import com.github.erikrz.pokeapi.dto.item.Item;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class EvolutionChain implements PokeApiIdResource {

    private final Integer id;
    private final NamedApiResource<Item> item;
    private final ChainLink chain;

}
