package com.github.erikrz.pokeapi.client.modules;

import com.github.erikrz.pokeapi.dto.ApiResourceList;
import com.github.erikrz.pokeapi.dto.machine.Machine;

import feign.Param;
import feign.RequestLine;

public interface MachinesClient {

    @RequestLine("GET /machine?offset={offset}&limit={offset}")
    ApiResourceList<Machine> getMachines(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /machine/{id}")
    Machine getMachine(@Param("id") Integer id);
}
