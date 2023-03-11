package com.github.erikrz.pokeapi.client;

import com.github.erikrz.pokeapi.client.modules.BerriesClient;
import com.github.erikrz.pokeapi.client.modules.ContestsClient;
import com.github.erikrz.pokeapi.client.modules.EncountersClient;
import com.github.erikrz.pokeapi.client.modules.EvolutionsClient;
import com.github.erikrz.pokeapi.client.modules.GamesClient;
import com.github.erikrz.pokeapi.client.modules.ItemsClient;
import com.github.erikrz.pokeapi.client.modules.LocationsClient;
import com.github.erikrz.pokeapi.client.modules.MachinesClient;
import com.github.erikrz.pokeapi.client.modules.MovesClient;
import com.github.erikrz.pokeapi.client.modules.PokemonClient;
import com.github.erikrz.pokeapi.client.modules.UtilityClient;

public interface PokeApiClient extends BerriesClient, ContestsClient, EncountersClient, EvolutionsClient, GamesClient,
        ItemsClient, LocationsClient, MachinesClient, MovesClient, PokemonClient, UtilityClient {

}
