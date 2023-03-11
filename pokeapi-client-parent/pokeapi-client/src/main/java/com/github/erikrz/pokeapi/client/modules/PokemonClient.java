package com.github.erikrz.pokeapi.client.modules;

import com.github.erikrz.pokeapi.dto.ApiResourceList;
import com.github.erikrz.pokeapi.dto.NamedApiResourceList;
import com.github.erikrz.pokeapi.dto.ability.Ability;
import com.github.erikrz.pokeapi.dto.characteristic.Characteristic;
import com.github.erikrz.pokeapi.dto.egggroup.EggGroup;
import com.github.erikrz.pokeapi.dto.gender.Gender;
import com.github.erikrz.pokeapi.dto.growthrate.GrowthRate;
import com.github.erikrz.pokeapi.dto.nature.Nature;
import com.github.erikrz.pokeapi.dto.pokemon.PokeathlonStat;
import com.github.erikrz.pokeapi.dto.pokemon.Pokemon;
import com.github.erikrz.pokeapi.dto.pokemoncolor.PokemonColor;
import com.github.erikrz.pokeapi.dto.pokemonform.PokemonForm;
import com.github.erikrz.pokeapi.dto.pokemonhabitat.PokemonHabitat;
import com.github.erikrz.pokeapi.dto.pokemonshape.PokemonShape;
import com.github.erikrz.pokeapi.dto.pokemonspecies.PokemonSpecies;
import com.github.erikrz.pokeapi.dto.stat.Stat;
import com.github.erikrz.pokeapi.dto.type.Type;

import feign.Param;
import feign.RequestLine;

public interface PokemonClient {

    @RequestLine("GET /ability?offset={offset}&limit={offset}")
    NamedApiResourceList<Ability> getAbilities(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /ability/{id}")
    Ability getAbility(@Param("id") Integer id);

    @RequestLine("GET /ability/{name}")
    Ability getAbility(@Param("name") String name);


    @RequestLine("GET /characteristic?offset={offset}&limit={offset}")
    ApiResourceList<Characteristic> getCharacteristics(@Param("offset") Integer offset,
                                                       @Param("limit") Integer limit);

    @RequestLine("GET /characteristic/{id}")
    Characteristic getCharacteristic(@Param("id") Integer id);


    @RequestLine("GET /egg-group?offset={offset}&limit={offset}")
    NamedApiResourceList<EggGroup> getEggGroups(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /egg-group/{id}")
    EggGroup getEggGroup(@Param("id") Integer id);

    @RequestLine("GET /egg-group/{name}")
    EggGroup getEggGroup(@Param("name") String name);


    @RequestLine("GET /gender?offset={offset}&limit={offset}")
    NamedApiResourceList<Gender> getGenders(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /gender/{id}")
    Gender getGender(@Param("id") Integer id);

    @RequestLine("GET /gender/{name}")
    Gender getGender(@Param("name") String name);


    @RequestLine("GET /growth-rate?offset={offset}&limit={offset}")
    NamedApiResourceList<GrowthRate> getGrowthRates(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /growth-rate/{id}")
    GrowthRate getGrowthRate(@Param("id") Integer id);

    @RequestLine("GET /growth-rate/{name}")
    GrowthRate getGrowthRate(@Param("name") String name);


    @RequestLine("GET /nature?offset={offset}&limit={offset}")
    NamedApiResourceList<Nature> getNatures(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /nature/{id}")
    Nature getNature(@Param("id") Integer id);

    @RequestLine("GET /nature/{name}")
    Nature getNature(@Param("name") String name);


    @RequestLine("GET /pokeathlon-stat?offset={offset}&limit={offset}")
    NamedApiResourceList<PokeathlonStat> getPokeathlonStats(@Param("offset") Integer offset,
                                                            @Param("limit") Integer limit);

    @RequestLine("GET /pokeathlon-stat/{id}")
    PokeathlonStat getPokeathlonStat(@Param("id") Integer id);

    @RequestLine("GET /pokeathlon-stat/{name}")
    PokeathlonStat getPokeathlonStat(@Param("name") String name);

    @RequestLine("GET /pokemon?offset={offset}&limit={offset}")
    NamedApiResourceList<Pokemon> getPokemons(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /pokemon/{id}")
    Pokemon getPokemon(@Param("id") Integer id);

    @RequestLine("GET /pokemon/{name}")
    Pokemon getPokemon(@Param("name") String name);


    @RequestLine("GET /pokemon-color?offset={offset}&limit={offset}")
    NamedApiResourceList<PokemonColor> getPokemonColors(@Param("offset") Integer offset,
                                                        @Param("limit") Integer limit);

    @RequestLine("GET /pokemon-color/{id}")
    PokemonColor getPokemonColor(@Param("id") Integer id);

    @RequestLine("GET /pokemon-color/{name}")
    PokemonColor getPokemonColor(@Param("name") String name);

    @RequestLine("GET /pokemon-form?offset={offset}&limit={offset}")
    NamedApiResourceList<PokemonForm> getPokemonForms(@Param("offset") Integer offset,
                                                      @Param("limit") Integer limit);

    @RequestLine("GET /pokemon-form/{id}")
    PokemonForm getPokemonForm(@Param("id") Integer id);

    @RequestLine("GET /pokemon-form/{name}")
    PokemonForm getPokemonForm(@Param("name") String name);


    @RequestLine("GET /pokemon-habitat?offset={offset}&limit={offset}")
    NamedApiResourceList<PokemonHabitat> getPokemonHabitats(@Param("offset") Integer offset,
                                                            @Param("limit") Integer limit);

    @RequestLine("GET /pokemon-habitat/{id}")
    PokemonHabitat getPokemonHabitat(@Param("id") Integer id);

    @RequestLine("GET /pokemon-habitat/{name}")
    PokemonHabitat getPokemonHabitat(@Param("name") String name);


    @RequestLine("GET /pokemon-shape?offset={offset}&limit={offset}")
    NamedApiResourceList<PokemonShape> getPokemonShapes(@Param("offset") Integer offset,
                                                        @Param("limit") Integer limit);

    @RequestLine("GET /pokemon-shape/{id}")
    PokemonShape getPokemonShape(@Param("id") Integer id);

    @RequestLine("GET /pokemon-shape/{name}")
    PokemonShape getPokemonShape(@Param("name") String name);


    @RequestLine("GET /pokemon-species?offset={offset}&limit={offset}")
    NamedApiResourceList<PokemonSpecies> getPokemonSpecies(@Param("offset") Integer offset,
                                                           @Param("limit") Integer limit);

    @RequestLine("GET /pokemon-species/{id}")
    PokemonSpecies getPokemonSpecies(@Param("id") Integer id);

    @RequestLine("GET /pokemon-species/{name}")
    PokemonSpecies getPokemonSpecies(@Param("name") String name);


    @RequestLine("GET /stat?offset={offset}&limit={offset}")
    NamedApiResourceList<Stat> getStats(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /stat/{id}")
    Stat getStat(@Param("id") Integer id);

    @RequestLine("GET /stat/{name}")
    Stat getStat(@Param("name") String name);


    @RequestLine("GET /type?offset={offset}&limit={offset}")
    NamedApiResourceList<Type> getTypes(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /type/{id}")
    Type getType(@Param("id") Integer id);

    @RequestLine("GET /type/{name}")
    Type getType(@Param("name") String name);
}
