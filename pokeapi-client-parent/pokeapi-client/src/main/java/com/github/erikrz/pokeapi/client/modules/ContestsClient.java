package com.github.erikrz.pokeapi.client.modules;


import com.github.erikrz.pokeapi.dto.ApiResourceList;
import com.github.erikrz.pokeapi.dto.NamedApiResourceList;
import com.github.erikrz.pokeapi.dto.contesteffect.ContestEffect;
import com.github.erikrz.pokeapi.dto.contesttype.ContestType;
import com.github.erikrz.pokeapi.dto.supercontesteffect.SuperContestEffect;

import feign.Param;
import feign.RequestLine;

public interface ContestsClient {

    @RequestLine("GET /contest-effect?offset={offset}&limit={offset}")
    ApiResourceList<ContestEffect> getContestEffects(@Param("offset") Integer offset,
                                                     @Param("limit") Integer limit);

    @RequestLine("GET /contest-effect/{id}")
    ContestEffect getContestEffect(@Param("id") Integer id);


    @RequestLine("GET /contest-type?offset={offset}&limit={offset}")
    NamedApiResourceList<ContestType> getContestTypes(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /contest-type/{id}")
    ContestType getContestType(@Param("id") Integer id);

    @RequestLine("GET /contest-type/{name}")
    ContestType getContestType(@Param("name") String name);


    @RequestLine("GET /super-contest-effect?offset={offset}&limit={offset}")
    ApiResourceList<SuperContestEffect> getSuperContestEffects(@Param("offset") Integer offset,
                                                               @Param("limit") Integer limit);

    @RequestLine("GET /super-contest-effect/{id}")
    SuperContestEffect getSuperContestEffect(@Param("id") Integer id);

}
