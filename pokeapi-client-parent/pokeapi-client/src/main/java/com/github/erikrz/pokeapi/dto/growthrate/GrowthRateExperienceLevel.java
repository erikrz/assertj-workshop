package com.github.erikrz.pokeapi.dto.growthrate;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class GrowthRateExperienceLevel {

    private final Integer level;
    private final Integer experience;
}
