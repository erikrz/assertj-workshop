package com.github.erikrz.pokeapi.dto.itemflingeffect;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Effect;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.item.Item;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ItemFlingEffect implements PokeApiNameResource {

    private final Integer id;
    private final String name;
    private final List<Effect> effectEntries;
    private final List<NamedApiResource<Item>> items;

}
