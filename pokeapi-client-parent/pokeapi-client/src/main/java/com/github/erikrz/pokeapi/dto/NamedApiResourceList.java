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

    /**
     * The total number of resources available from this API.
     */
    private final Integer count;

    /**
     * The URL for the next page in the list.
     */
    private final String next;

    /**
     * The URL for the previous page in the list.
     */
    private final Boolean previous;
    
    /**
     * A list of named API resources.
     */
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
