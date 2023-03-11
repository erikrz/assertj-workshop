package com.github.erikrz.pokeapi.dto.item;

import java.util.List;

import com.github.erikrz.pokeapi.dto.ApiResource;
import com.github.erikrz.pokeapi.dto.GenerationGameIndex;
import com.github.erikrz.pokeapi.dto.MachineVersionDetail;
import com.github.erikrz.pokeapi.dto.Name;
import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.VerboseEffect;
import com.github.erikrz.pokeapi.dto.VersionGroupFlavorText;
import com.github.erikrz.pokeapi.dto.evolutionchain.EvolutionChain;
import com.github.erikrz.pokeapi.dto.itemattribute.ItemAttribute;
import com.github.erikrz.pokeapi.dto.itemcategory.ItemCategory;
import com.github.erikrz.pokeapi.dto.itemflingeffect.ItemFlingEffect;
import com.github.erikrz.pokeapi.locale.Localizable;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Item implements PokeApiNameResource, Localizable {

    private final Integer id;
    private final String name;
    private final Integer cost;
    private final Integer flingPower;
    private final NamedApiResource<ItemFlingEffect> flingEffect;
    private final List<NamedApiResource<ItemAttribute>> attributes;
    private final List<NamedApiResource<ItemCategory>> category;
    private final List<VerboseEffect> effectEntries;
    private final List<VersionGroupFlavorText> flavorTextEntries;
    private final List<GenerationGameIndex> gameIndices;
    private final List<Name> names;
    private final ItemSprites sprites;
    private final List<ItemHolderPokemon> heldByPokemon;
    private final ApiResource<EvolutionChain> babyTriggerFor;
    private final List<MachineVersionDetail> machines;

}
