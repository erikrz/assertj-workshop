
package com.github.erikrz.contacts.client.feign.properties;

import java.time.Duration;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import feign.Logger;
import lombok.Data;

import static feign.Logger.Level.BASIC;

/**
 * This class provides a contextual way to define needed properties to be fulfilled in a project, be it directly in the
 * {@code application.yml} file, or read from a Spring configuration Server.
 */
@Data
@ConfigurationProperties(prefix = ContactsClientProperties.PREFIX)
public class ContactsClientProperties {

    public static final String PREFIX = "services.settings.contacts-service";
    public static final Duration DEFAULT_CONNECTION_TIMEOUT = Duration.ofSeconds(20);
    public static final Duration DEFAULT_READ_TIMEOUT = Duration.ofSeconds(10);
    public static final Integer DEFAULT_TOTAL_CONNECTIONS = 4096;
    public static final Integer DEFAULT_TOTAL_CONNECTIONS_PER_ROUTE = 4096;
    public static final Logger.Level DEFAULT_LOGGER_LEVEL = BASIC;

    /**
     * Base URI to consume Contacts Service, i.e.
     * {@literal https://localhost:8080} .
     */
    @NotNull
    @NotBlank
    private final String baseUri;

    /**
     * Connection timeout duration, i.e. {@code 20s} ({@link #DEFAULT_CONNECTION_TIMEOUT})
     */
    private final Duration connectionTimeout;

    /**
     * Connection timeout duration, i.e. {@code 10s} ({@link #DEFAULT_READ_TIMEOUT})
     */
    private final Duration readTimeout;

    /**
     * Max number of connections for Feign's HttpClient, i.e. {@value DEFAULT_TOTAL_CONNECTIONS}.
     */
    private final Integer maxConnTotal;

    /**
     * Max number of connections per route for Feign's HttpClient, i.e. {@value DEFAULT_TOTAL_CONNECTIONS_PER_ROUTE}.
     */
    private final Integer maxConnPerRoute;


    /**
     * Log level for this client, i.e {@link #DEFAULT_LOGGER_LEVEL}.
     */
    private final Logger.Level loggerLevel;

    @ConstructorBinding
    public ContactsClientProperties(@NotNull @NotBlank String baseUri, Duration connectionTimeout, Duration readTimeout,
                                    Integer maxConnTotal, Integer maxConnPerRoute, Logger.Level loggerLevel) {
        this.baseUri = baseUri;
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.maxConnTotal = maxConnTotal;
        this.maxConnPerRoute = maxConnPerRoute;
        this.loggerLevel = loggerLevel;
    }
}
