package com.github.erikrz.pokeapi.dto.move;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.language.Language;
import com.github.erikrz.pokeapi.dto.versiongroup.VersionGroup;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class MoveFlavorText {

    private final String flavorText;
    private final NamedApiResource<Language> language;
    private final NamedApiResource<VersionGroup> versionGroup;

}
