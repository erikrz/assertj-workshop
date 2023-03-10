package com.github.erikrz.pokeapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
@AllArgsConstructor
public class NamedApiResource<T extends PokeApiNameResource> {

    private final String name;
    private final String url;
}
