package com.github.erikrz.pokeapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ApiResourceList<T extends PokeApiIdResource> implements PokeApiIdResource {

    private final Integer count;
    private final String next;
    private final Boolean previous;
    private final List<ApiResource<T>> results;

    @Override
    @JsonIgnore
    public Integer getId() {
        return 0;
    }

}
