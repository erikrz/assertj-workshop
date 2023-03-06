package com.github.erikrz.pokeapi.client.modules;

import com.github.erikrz.pokeapi.dto.NamedApiResourceList;
import com.github.erikrz.pokeapi.dto.berry.Berry;
import com.github.erikrz.pokeapi.dto.berryfirmness.BerryFirmness;
import com.github.erikrz.pokeapi.dto.berryflavor.BerryFlavor;

import feign.Param;
import feign.RequestLine;

public interface BerriesClient {

    @RequestLine("GET /berry?offset={offset}&limit={offset}")
    NamedApiResourceList<Berry> getBerries(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /berry/{id}")
    Berry getBerry(@Param("id") Integer id);

    @RequestLine("GET /berry/{name}")
    Berry getBerry(@Param("name") String name);


    @RequestLine("GET /berry-firmness?offset={offset}&limit={offset}")
    NamedApiResourceList<BerryFirmness> getBerryFirmness(@Param("offset") Integer offset,
                                                         @Param("limit") Integer limit);

    @RequestLine("GET /berry-firmness/{id}")
    BerryFirmness getBerryFirmness(@Param("id") Integer id);

    @RequestLine("GET /berry-firmness/{name}")
    BerryFirmness getBerryFirmness(@Param("name") String name);
    

    @RequestLine("GET /berry-flavor?offset={offset}&limit={offset}")
    NamedApiResourceList<BerryFlavor> getBerryFlavors(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /berry-flavor/{id}")
    BerryFlavor getBerryFlavor(@Param("id") Integer id);

    @RequestLine("GET /berry-flavor/{name}")
    BerryFlavor getBerryFlavor(@Param("name") String name);

}
