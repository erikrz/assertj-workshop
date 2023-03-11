package com.github.erikrz.pokeapi.client;

import com.github.erikrz.pokeapi.client.modules.BerriesClient;
import com.github.erikrz.pokeapi.client.modules.ContestsClient;
import com.github.erikrz.pokeapi.client.modules.EncountersClient;
import com.github.erikrz.pokeapi.client.modules.PokemonClient;

public interface PokeApiClient extends BerriesClient, ContestsClient, EncountersClient, PokemonClient {

}