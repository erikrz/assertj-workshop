
package com.github.erikrz.contacts.client.feign.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.erikrz.contacts.client.feign.ContactsClientFactory;
import com.github.erikrz.contacts.client.feign.properties.ContactsClientProperties;
import com.github.erikrz.contacts.client.feign.targets.ContactsIdempotentClient;
import com.github.erikrz.contacts.client.feign.targets.ContactsNonIdempotentClient;

/**
 * Contacts Service Client Configuration.
 * Spring Configuration class that configures and instances the Calendar Orchestration Service Client.
 * Just {@code @import} this configuration class into your application, provide the required properties defined in
 * {@link ContactsClientProperties} and you are good to go and use the client.
 */
@EnableConfigurationProperties(ContactsClientProperties.class)
@Configuration
public class ContactsServiceClientConfiguration {
    private final ContactsClientFactory factory;

    @Autowired
    public ContactsServiceClientConfiguration(ContactsClientProperties properties) {
        this.factory = new ContactsClientFactory(properties);
    }

    @Bean("contactsIdempotentClient")
    public ContactsIdempotentClient calendarIdempotentClient() {
        return factory.contactsIdempotentClient();
    }

    @Bean("contactsNonIdempotentClient")
    public ContactsNonIdempotentClient calendarNonIdempotentClient() {
        return factory.contactsNonIdempotentClient();
    }

}
