package com.github.erikrz.contacts.client.feign.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@TestPropertySource(
        properties = "services.settings.contacts-service.base-uri=https://erikrz.com/contacts-service")
@ContextConfiguration(
        initializers = ConfigDataApplicationContextInitializer.class,
        classes = {ContactsServiceClientConfiguration.class})
class ContactsServiceClientConfigurationTest {

    @Autowired
    private ContactsServiceClientConfiguration configuration;

    @Test
    void testPropertiesLoaded() {
        assertThat(configuration).isNotNull();
    }

}