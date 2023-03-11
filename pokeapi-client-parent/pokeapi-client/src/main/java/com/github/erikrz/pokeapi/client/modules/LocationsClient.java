package com.github.erikrz.pokeapi.client.modules;


import com.github.erikrz.pokeapi.dto.NamedApiResourceList;
import com.github.erikrz.pokeapi.dto.location.Location;
import com.github.erikrz.pokeapi.dto.locationarea.LocationArea;
import com.github.erikrz.pokeapi.dto.palparkarea.PalParkArea;
import com.github.erikrz.pokeapi.dto.region.Region;

import feign.Param;
import feign.RequestLine;

public interface LocationsClient {

    @RequestLine("GET /location?offset={offset}&limit={offset}")
    NamedApiResourceList<Location> getLocations(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /location/{id}")
    Location getLocation(@Param("id") Integer id);

    @RequestLine("GET /location/{name}")
    Location getLocation(@Param("name") String name);


    @RequestLine("GET /location-area?offset={offset}&limit={offset}")
    NamedApiResourceList<LocationArea> getLocationAreas(@Param("offset") Integer offset,
                                                        @Param("limit") Integer limit);

    @RequestLine("GET /location-area/{id}")
    LocationArea getLocationArea(@Param("id") Integer id);

    @RequestLine("GET /location-area/{name}")
    LocationArea getLocationArea(@Param("name") String name);


    @RequestLine("GET /pal-park-area?offset={offset}&limit={offset}")
    NamedApiResourceList<PalParkArea> getPalParkAreas(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /pal-park-area/{id}")
    PalParkArea getPalParkArea(@Param("id") Integer id);

    @RequestLine("GET /pal-park-area/{name}")
    PalParkArea getPalParkArea(@Param("name") String name);


    @RequestLine("GET /region?offset={offset}&limit={offset}")
    NamedApiResourceList<Region> getRegions(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /region/{id}")
    Region getRegion(@Param("id") Integer id);

    @RequestLine("GET /region/{name}")
    Region getRegion(@Param("name") String name);
}
