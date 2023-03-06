package com.github.erikrz.pokeapi.dto.machine;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiIdResource;
import com.github.erikrz.pokeapi.dto.item.Item;
import com.github.erikrz.pokeapi.dto.move.Move;
import com.github.erikrz.pokeapi.dto.versiongroup.VersionGroup;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Machine implements PokeApiIdResource {

    private final Integer id;
    private final NamedApiResource<Item> item;
    private final NamedApiResource<Move> move;
    private final NamedApiResource<VersionGroup> versionGroup;

}
