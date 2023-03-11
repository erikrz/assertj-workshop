package com.github.erikrz.pokeapi.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ApiResource<T> {

    private final String url;

}
