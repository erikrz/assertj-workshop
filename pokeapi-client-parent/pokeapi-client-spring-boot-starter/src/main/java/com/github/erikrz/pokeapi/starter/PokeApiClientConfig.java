package com.github.erikrz.pokeapi.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.github.erikrz.pokeapi.client.PokeApiClient;
import com.github.erikrz.pokeapi.client.PokeApiClientFactory;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.SNAKE_CASE;

/**
 * PokeAPI Client Auto Configuration.
 * Spring Configuration class that configures and instances the PokeAPI Client.
 * Just {@code @import} this configuration class into your application, provide the required properties defined in
 * {@link PokeApiClientProperties} and you are good to go and use the {@link PokeApiClient} bean.
 */
@EnableConfigurationProperties(PokeApiClientProperties.class)
@Configuration
public class PokeApiClientConfig {

    private final PokeApiClientFactory pokeAPIClientFactory;
    private final PokeApiClientProperties properties;

    @Autowired
    public PokeApiClientConfig(PokeApiClientProperties properties,
                               ObjectMapper pokeApiClientObjectMapper) {
        this.properties = properties;
        this.pokeAPIClientFactory =
                new PokeApiClientFactory(pokeApiClientObjectMapper, properties.getMaxConnTotal(),
                        properties.getMaxConnPerRoute());
    }

    @Bean
    public PokeApiClient meetingOrchestrationClient() {
        return pokeAPIClientFactory.buildClient(PokeApiClient.class, properties.getBaseUri());
    }

    @Bean(name = "pokeApiClientObjectMapper")
    public ObjectMapper pokeApiClientObjectMapper() {
        return JsonMapper.builder()
                .propertyNamingStrategy(SNAKE_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .build();
    }
}
