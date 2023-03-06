package com.github.erikrz.pokeapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class NamedApiResourceList<T extends PokeApiNameResource> implements PokeApiNameResource {

    private final Integer count;
    private final String next;
    private final Boolean previous;
    private final List<NamedApiResource<T>> results;

    @Override
    @JsonIgnore
    public Integer getId() {
        return 0;
    }

    @Override
    @JsonIgnore
    public String getName() {
        return "";
    }

}
