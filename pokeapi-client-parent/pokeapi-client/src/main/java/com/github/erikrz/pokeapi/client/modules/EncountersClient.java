package com.github.erikrz.pokeapi.client.modules;

import com.github.erikrz.pokeapi.dto.NamedApiResourceList;
import com.github.erikrz.pokeapi.dto.encountercondition.EncounterCondition;
import com.github.erikrz.pokeapi.dto.encounterconditionvalue.EncounterConditionValue;
import com.github.erikrz.pokeapi.dto.encountermethod.EncounterMethod;

import feign.Param;
import feign.RequestLine;

public interface EncountersClient {

    @RequestLine("GET /encounter-method?offset={offset}&limit={offset}")
    NamedApiResourceList<EncounterMethod> getEncounterMethods(@Param("offset") Integer offset,
                                                              @Param("limit") Integer limit);

    @RequestLine("GET /encounter-method/{id}")
    EncounterMethod getEncounterMethod(@Param("id") Integer id);

    @RequestLine("GET /encounter-method/{name}")
    EncounterMethod getEncounterMethod(@Param("name") String name);


    @RequestLine("GET /encounter-condition?offset={offset}&limit={offset}")
    NamedApiResourceList<EncounterCondition> getEncounterConditions(@Param("offset") Integer offset,
                                                                    @Param("limit") Integer limit);

    @RequestLine("GET /encounter-condition/{id}")
    EncounterCondition getEncounterCondition(@Param("id") Integer id);

    @RequestLine("GET /encounter-condition/{name}")
    EncounterMethod getEncounterCondition(@Param("name") String name);


    @RequestLine("GET /encounter-condition-value?offset={offset}&limit={offset}")
    NamedApiResourceList<EncounterConditionValue> getEncounterConditionValues(@Param("offset") Integer offset,
                                                                              @Param("limit") Integer limit);

    @RequestLine("GET /encounter-condition-value/{id}")
    EncounterConditionValue getEncounterConditionValue(@Param("id") Integer id);

    @RequestLine("GET /encounter-condition-value/{name}")
    EncounterConditionValue getEncounterConditionValue(@Param("name") String name);
}
