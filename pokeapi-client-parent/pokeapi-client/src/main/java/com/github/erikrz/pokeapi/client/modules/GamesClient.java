package com.github.erikrz.pokeapi.client.modules;


import com.github.erikrz.pokeapi.dto.NamedApiResourceList;
import com.github.erikrz.pokeapi.dto.generation.Generation;
import com.github.erikrz.pokeapi.dto.pokedex.Pokedex;
import com.github.erikrz.pokeapi.dto.version.Version;
import com.github.erikrz.pokeapi.dto.versiongroup.VersionGroup;

import feign.Param;
import feign.RequestLine;

public interface GamesClient {

    @RequestLine("GET /generation?offset={offset}&limit={offset}")
    NamedApiResourceList<Generation> getGenerations(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /generation/{id}")
    Generation getGeneration(@Param("id") Integer id);

    @RequestLine("GET /generation/{id}")
    Generation getGeneration(@Param("name") String name);

    @RequestLine("GET /pokedex?offset={offset}&limit={offset}")
    NamedApiResourceList<Pokedex> getPokedexs(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /pokedex/{id}")
    Pokedex getPokedex(@Param("id") Integer id);

    @RequestLine("GET /pokedex/{name}")
    Pokedex getPokedex(@Param("name") String name);

    @RequestLine("GET /version?offset={offset}&limit={offset}")
    NamedApiResourceList<Version> getVersions(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /version/{id}")
    Version getVersion(@Param("id") Integer id);

    @RequestLine("GET /version/{name}")
    Version getVersion(@Param("name") String name);

    @RequestLine("GET /version-group?offset={offset}&limit={offset}")
    NamedApiResourceList<VersionGroup> getVersionGroups(@Param("offset") Integer offset,
                                                        @Param("limit") Integer limit);

    @RequestLine("GET /version-group/{id}")
    VersionGroup getVersionGroup(@Param("id") Integer id);

    @RequestLine("GET /version-group/{name}")
    VersionGroup getVersionGroup(@Param("name") String name);
}
