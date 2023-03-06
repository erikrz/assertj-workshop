package com.github.erikrz.pokeapi.dto.berry;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.berryfirmness.BerryFirmness;
import com.github.erikrz.pokeapi.dto.item.Item;
import com.github.erikrz.pokeapi.dto.type.Type;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class Berry implements PokeApiNameResource {

    private final Integer id;
    private final String name;
    private final Integer growthTime;
    private final Integer maxHarvest;
    private final Integer naturalGiftPower;
    private final Integer size;
    private final Integer smoothness;
    private final Integer soilDryness;
    private final NamedApiResource<BerryFirmness> firmness;
    private final List<BerryFlavorMap> flavors;
    private final NamedApiResource<Item> item;
    private final NamedApiResource<Type> naturalGiftType;

}
