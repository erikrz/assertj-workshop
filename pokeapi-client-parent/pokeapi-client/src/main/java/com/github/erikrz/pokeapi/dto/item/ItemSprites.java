package com.github.erikrz.pokeapi.dto.item;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class ItemSprites {

    private final String imageUrl;
}
