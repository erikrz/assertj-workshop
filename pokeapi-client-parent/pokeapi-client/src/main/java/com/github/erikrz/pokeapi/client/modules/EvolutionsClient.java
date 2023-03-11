package com.github.erikrz.pokeapi.client.modules;

import com.github.erikrz.pokeapi.dto.ApiResourceList;
import com.github.erikrz.pokeapi.dto.NamedApiResourceList;
import com.github.erikrz.pokeapi.dto.evolutionchain.EvolutionChain;
import com.github.erikrz.pokeapi.dto.evolutiontrigger.EvolutionTrigger;

import feign.Param;
import feign.RequestLine;


public interface EvolutionsClient {

    @RequestLine("GET /evolution-chain?offset={offset}&limit={offset}")
    ApiResourceList<EvolutionChain> getEvolutionChains(@Param("offset") Integer offset,
                                                       @Param("limit") Integer limit);

    @RequestLine("GET /evolution-chain/{id}")
    EvolutionChain getEvolutionChain(@Param("id") Integer id);

    @RequestLine("GET /evolution-trigger?offset={offset}&limit={offset}")
    NamedApiResourceList<EvolutionTrigger> getEvolutionTriggers(@Param("offset") Integer offset,
                                                                @Param("limit") Integer limit);

    @RequestLine("GET /evolution-trigger/{id}")
    EvolutionTrigger getEvolutionTrigger(@Param("id") Integer id);

    @RequestLine("GET /evolution-trigger/{name}")
    EvolutionTrigger getEvolutionTrigger(@Param("name") String name);
}
