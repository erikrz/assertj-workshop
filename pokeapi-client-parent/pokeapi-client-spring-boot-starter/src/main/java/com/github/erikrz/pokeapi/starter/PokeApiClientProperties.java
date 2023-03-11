package com.github.erikrz.pokeapi.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * This class provides a contextual way to define needed properties to be fulfilled in a project, be it directly in the
 * {@code application.yml} file, or read from a Spring Configuration Server.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = PokeApiClientProperties.PREFIX)
public class PokeApiClientProperties {

    public static final String PREFIX = "pokeapi.client";

    /**
     * Environment-dependent URL where the Poke API is published and can be consumed,
     * i.e. https://pokeapi.co/api/v2.
     */
    private String baseUri;

    /**
     * Max number of connections for Feign's ApacheHttpClient, i.e. 4096.
     */
    private int maxConnTotal;

    /**
     * Max number of connections per route for Feign's ApacheHttpClient, i.e. 4096.
     */
    private int maxConnPerRoute;

}
