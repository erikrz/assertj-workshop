package com.github.erikrz.pokeapi.dto.pokemon;

import java.util.List;

import com.github.erikrz.pokeapi.dto.NamedApiResource;
import com.github.erikrz.pokeapi.dto.PokeApiNameResource;
import com.github.erikrz.pokeapi.dto.VersionGameIndex;
import com.github.erikrz.pokeapi.dto.pokemonform.PokemonForm;
import com.github.erikrz.pokeapi.dto.pokemonspecies.PokemonSpecies;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 * Pokémon are the creatures that inhabit the world of the Pokémon games. They can be caught using Pokéballs and
 * trained by battling with other Pokémon. Each Pokémon belongs to a specific species but may take on a variant
 * which makes it differ from other Pokémon of the same species, such as base stats, available abilities and
 * typings. See Bulbapedia for greater detail.
 *
 * @see <a href="http://bulbapedia.bulbagarden.net/wiki/Pok%C3%A9mon_(species)">Bulbapedia</a>
 */
@Data
@Jacksonized
@Builder(toBuilder = true)
public class Pokemon implements PokeApiNameResource {

    /**
     * The identifier for this resource.
     */
    private final Integer id;

    /**
     * The name for this resource.
     */
    private final String name;

    /**
     * The base experience gained for defeating this Pokémon.
     */
    private final Integer baseExperience;

    /**
     * The height of this Pokémon in decimetres.
     */
    private final Integer height;

    /**
     * Set for exactly one Pokémon used as the default for each species.
     */
    private final Boolean isDefault;

    /**
     * Order for sorting. Almost national order, except families are grouped together.
     */
    private final Integer order;

    /**
     * The weight of this Pokémon in hectograms.
     */
    private final Integer weight;

    /**
     * A list of abilities this Pokémon could potentially have.
     */
    private final List<PokemonAbility> abilities;

    /**
     * A list of forms this Pokémon can take on.
     */
    private final List<NamedApiResource<PokemonForm>> forms;

    /**
     * list of game indices relevent to Pokémon item by generation.
     */
    private final List<VersionGameIndex> gameIndices;

    /**
     * A list of items this Pokémon may be holding when encountered.
     */
    private final List<PokemonHeldItem> heldItems;

    /**
     * A link to a list of location areas, as well as encounter details pertaining to specific versions.
     */
    private final String locationAreaEncounters;

    /**
     * A list of moves along with learn methods and level details pertaining to specific version groups.
     */
    private final List<PokemonMove> moves;

    /**
     * A set of sprites used to depict this Pokémon in the game.  A visual representation of the various sprites can be found at PokeAPI/sprites.
     *
     * @see <a href="https://github.com/PokeAPI/sprites#sprites">PokeAPI/sprites</a>
     */
    private final PokemonSprites sprites;

    /**
     * The species this Pokémon belongs to.
     */
    private final NamedApiResource<PokemonSpecies> species;

    /**
     * A list of base stat values for this Pokémon.
     */
    private final List<PokemonStat> stats;

    /**
     * A list of details showing types this Pokémon has.
     */
    private final List<PokemonType> types;

    /**
     * A list of details showing types this pokémon had in previous generations.
     */
    private final List<PokemonTypePast> pastTypes;

}
