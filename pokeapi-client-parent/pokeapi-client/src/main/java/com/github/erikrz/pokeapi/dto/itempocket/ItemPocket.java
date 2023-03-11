package com.github.erikrz.pokeapi.dto.itempocket;

import java.util.List;

import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.itemcategory.ItemCategory;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ItemPocket implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final List<NamedApiResource<ItemCategory>> categories;
    private final List<Name> names;
}
