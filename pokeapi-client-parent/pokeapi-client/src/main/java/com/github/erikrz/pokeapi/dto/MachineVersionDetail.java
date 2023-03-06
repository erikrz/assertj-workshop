package com.github.erikrz.pokeapi.dto;

import com.github.erikrz.pokeapi.dto.machine.Machine;
import com.github.erikrz.pokeapi.dto.versiongroup.VersionGroup;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(toBuilder = true)
public class MachineVersionDetail {

    private final ApiResource<Machine> machine;
    private final NamedApiResource<VersionGroup> versionGroup;


}
