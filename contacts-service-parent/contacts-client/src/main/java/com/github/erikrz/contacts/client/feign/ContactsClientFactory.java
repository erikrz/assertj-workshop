
package com.github.erikrz.contacts.client.feign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.cloud.openfeign.support.PageJacksonModule;
import org.springframework.cloud.openfeign.support.SortJacksonModule;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.erikrz.contacts.client.feign.decoder.ContactsErrorDecoder;
import com.github.erikrz.contacts.client.feign.interceptor.ContentTypeInterceptor;
import com.github.erikrz.contacts.client.feign.properties.ContactsClientProperties;
import com.github.erikrz.contacts.client.feign.targets.ContactsIdempotentClient;
import com.github.erikrz.contacts.client.feign.targets.ContactsNonIdempotentClient;

import feign.Feign;
import feign.Request;
import feign.RequestInterceptor;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.optionals.OptionalDecoder;
import feign.slf4j.Slf4jLogger;

import static com.github.erikrz.contacts.client.feign.properties.ContactsClientProperties.DEFAULT_CONNECTION_TIMEOUT;
import static com.github.erikrz.contacts.client.feign.properties.ContactsClientProperties.DEFAULT_LOGGER_LEVEL;
import static com.github.erikrz.contacts.client.feign.properties.ContactsClientProperties.DEFAULT_READ_TIMEOUT;
import static com.github.erikrz.contacts.client.feign.properties.ContactsClientProperties.DEFAULT_TOTAL_CONNECTIONS;
import static com.github.erikrz.contacts.client.feign.properties.ContactsClientProperties.DEFAULT_TOTAL_CONNECTIONS_PER_ROUTE;
import static feign.Retryer.NEVER_RETRY;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Contacts Service Client Factory.
 */
public class ContactsClientFactory {

    private final ContactsErrorDecoder contactsErrorDecoder;
    private final ObjectMapper objectMapper;
    private final ContentTypeInterceptor contentTypeInterceptor;
    private final ContactsClientProperties properties;

    public ContactsClientFactory(ContactsClientProperties properties) {
        this.contactsErrorDecoder = new ContactsErrorDecoder();
        this.contentTypeInterceptor = new ContentTypeInterceptor();
        this.properties = properties;
        this.objectMapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .registerModule(new JavaTimeModule())
                .registerModule(new JsonNullableModule())
                .registerModule(new PageJacksonModule())
                .registerModule(new SortJacksonModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Function to create a client with default behavior.
     *
     * @return an instance of ContactsIdempotentClient.
     */
    public ContactsIdempotentClient contactsIdempotentClient() {
        return commonFeignBuilder()
                .target(ContactsIdempotentClient.class, properties.getBaseUri());
    }

    /**
     * Function to create a client with custom interceptors.
     *
     * @param requestInterceptors optional interceptors to add.
     * @return an instance of ContactsIdempotentClient.
     */
    public ContactsIdempotentClient contactsIdempotentClient(RequestInterceptor... requestInterceptors) {
        var interceptors = new ArrayList<>(Arrays.asList(requestInterceptors));
        interceptors.add(contentTypeInterceptor);
        return commonFeignBuilder()
                .requestInterceptors(interceptors)
                .target(ContactsIdempotentClient.class, properties.getBaseUri());
    }

    /**
     * Function to create a client with default behavior.
     *
     * @return an instance of ContactsNonIdempotentClient.
     */
    public ContactsNonIdempotentClient contactsNonIdempotentClient() {
        return commonFeignBuilder()
                .retryer(NEVER_RETRY)
                .target(ContactsNonIdempotentClient.class, properties.getBaseUri());
    }

    /**
     * Function to create a client with custom interceptors.
     *
     * @param requestInterceptors optional interceptors to add.
     * @return an instance of ContactsNonIdempotentClient.
     */
    public ContactsNonIdempotentClient contactsNonIdempotentClient(RequestInterceptor... requestInterceptors) {
        var interceptors = new ArrayList<>(Arrays.asList(requestInterceptors));
        interceptors.add(contentTypeInterceptor);
        return commonFeignBuilder()
                .retryer(NEVER_RETRY)
                .requestInterceptors(interceptors)
                .target(ContactsNonIdempotentClient.class, properties.getBaseUri());
    }

    private Feign.Builder commonFeignBuilder() {
        return Feign.builder().client(apacheHttpClient())
                .logger(new Slf4jLogger())
                .logLevel(Optional.ofNullable(properties.getLoggerLevel()).orElse(DEFAULT_LOGGER_LEVEL))
                .encoder(new JacksonEncoder(this.objectMapper))
                .decoder(new OptionalDecoder(new JacksonDecoder(this.objectMapper)))
                .errorDecoder(this.contactsErrorDecoder)
                .requestInterceptors(defaultInterceptors())
                .dismiss404()
                .options(requestOptions());
    }

    private List<RequestInterceptor> defaultInterceptors() {
        return List.of(this.contentTypeInterceptor);
    }

    private Request.Options requestOptions() {
        return new Request.Options(
                (int) Optional.ofNullable(this.properties.getConnectionTimeout()).orElse(DEFAULT_CONNECTION_TIMEOUT)
                        .toMillis(),
                MILLISECONDS,
                (int) Optional.ofNullable(this.properties.getReadTimeout()).orElse(DEFAULT_READ_TIMEOUT)
                        .toMillis(),
                MILLISECONDS,
                true);
    }

    private ApacheHttpClient apacheHttpClient() {
        CloseableHttpClient apacheHttpClient = HttpClientBuilder.create()
                .setMaxConnPerRoute(Optional.ofNullable(properties.getMaxConnPerRoute())
                        .orElse(DEFAULT_TOTAL_CONNECTIONS_PER_ROUTE))
                .setMaxConnTotal(Optional.ofNullable(properties.getMaxConnTotal())
                        .orElse(DEFAULT_TOTAL_CONNECTIONS))
                .build();
        return new ApacheHttpClient(apacheHttpClient);
    }

}
