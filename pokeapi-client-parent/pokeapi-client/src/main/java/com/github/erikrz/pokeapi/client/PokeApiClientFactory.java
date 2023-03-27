package com.github.erikrz.pokeapi.client;

import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import feign.Client;
import feign.Feign;
import feign.Logger;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.SNAKE_CASE;

/**
 * Poke API Client Factory.
 */
public class PokeApiClientFactory {

    private final ObjectMapper objectMapper;

    private final Client client;

    public PokeApiClientFactory() {
        this.objectMapper = JsonMapper.builder()
                .propertyNamingStrategy(SNAKE_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .build();
        this.client = new ApacheHttpClient(HttpClientBuilder.create()
                .setMaxConnPerRoute(4096)
                .setMaxConnTotal(4096)
                .build());
    }

    public PokeApiClientFactory(ObjectMapper objectMapper, int maxConnTotal, int maxConnPerRoute) {
        this.objectMapper = objectMapper;
        this.client = new ApacheHttpClient(HttpClientBuilder.create()
                .setMaxConnPerRoute(maxConnPerRoute)
                .setMaxConnTotal(maxConnTotal)
                .build());
    }

    public PokeApiClient buildClient() {
        return buildClient(PokeApiClient.class, "https://pokeapi.co/api/v2");
    }

    public <T> T buildClient(Class<T> clazz) {
        return buildClient(clazz, "https://pokeapi.co/api/v2");
    }

    public <T> T buildClient(Class<T> clazz, String baseUri) {
        return buildFeignBuilder(Logger.Level.FULL).target(clazz, baseUri);
    }

    public <T> T buildClient(Class<T> clazz, String baseUri, Logger.Level level) {
        return buildFeignBuilder(level).target(clazz, baseUri);
    }

    private Feign.Builder buildFeignBuilder(Logger.Level level) {
        return Feign.builder()
                .client(client)
                .logger(new Slf4jLogger())
                .logLevel(level)
                //.dismiss404() I prefer to dismiss 404, but left commented for exception testing purposes.
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper));
    }


}
