package com.github.erikrz.contacts.client;

import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Client;
import feign.Feign;
import feign.Logger;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

/**
 * Contacts Client Factory.
 */
public class ContactsClientFactory {

    private final ObjectMapper objectMapper;

    private final Client client;

    public ContactsClientFactory(ObjectMapper objectMapper, int maxConnTotal, int maxConnPerRoute) {
        this.objectMapper = objectMapper;
        this.client = new ApacheHttpClient(HttpClientBuilder.create()
                .setMaxConnPerRoute(maxConnPerRoute)
                .setMaxConnTotal(maxConnTotal)
                .build());
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
                .dismiss404()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper));
    }


}
