
package com.github.erikrz.contacts.client.feign;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.erikrz.contacts.client.feign.properties.ContactsClientProperties;

import static feign.Logger.Level.FULL;
import static org.assertj.core.api.Assertions.assertThat;


class ContactsClientFactoryTest {

    private static final ContactsClientProperties defaultProperties =
            new ContactsClientProperties(
                    "https://localhost:8080",
                    null, null, null, null, null);

    private static final ContactsClientProperties customProperties =
            new ContactsClientProperties(
                    "https://erikrz.com/contacts-service",
                    Duration.ofSeconds(30), Duration.ofSeconds(30), 5, 5, FULL);
    private ContactsClientFactory defaultValuesFactory;
    private ContactsClientFactory customValuesFactory;


    @BeforeEach
    void setUp() {
        defaultValuesFactory = new ContactsClientFactory(defaultProperties);
        customValuesFactory = new ContactsClientFactory(customProperties);
    }

    @Test
    void given_default_values_when_instantiating_a_non_idempotent_client_then_default_values_are_used() {
        assertThat(defaultValuesFactory.contactsNonIdempotentClient()).isNotNull();
    }

    @Test
    void given_default_values_when_instantiating_an_idempotent_client_then_default_values_are_used() {
        assertThat(defaultValuesFactory.contactsIdempotentClient()).isNotNull();
    }

    @Test
    void given_custom_values_when_instantiating_a_non_idempotent_client_then_default_values_are_used() {
        assertThat(customValuesFactory.contactsNonIdempotentClient()).isNotNull();
    }

    @Test
    void given_custom_values_when_instantiating_an_idempotent_client_then_default_values_are_used() {
        assertThat(customValuesFactory.contactsIdempotentClient()).isNotNull();
    }
}