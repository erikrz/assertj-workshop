package com.github.erikrz.contacts.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.erikrz.contacts.client.ContactsClient;
import com.github.erikrz.contacts.client.ContactsClientFactory;

/**
 * Contacts Service Client Auto Configuration.
 * Spring Configuration class that configures and instances the Contacts Service Client.
 * Just {@code @import} this configuration class into your application, provide the required properties defined in
 * {@link ContactsServiceClientProperties} and you are good to go and use the {@link ContactsClient} bean.
 */
@EnableConfigurationProperties(ContactsServiceClientProperties.class)
@Configuration
public class ContactsServiceClientConfig {

    private final ContactsClientFactory contactsClientFactory;
    private final ContactsServiceClientProperties properties;

    @Autowired
    public ContactsServiceClientConfig(ContactsServiceClientProperties properties,
                                       ObjectMapper contactsServiceClientObjectMapper) {
        this.properties = properties;
        this.contactsClientFactory =
                new ContactsClientFactory(contactsServiceClientObjectMapper, properties.getMaxConnTotal(),
                        properties.getMaxConnPerRoute());
    }

    @Bean
    public ContactsClient meetingOrchestrationClient() {
        return contactsClientFactory.buildClient(ContactsClient.class, properties.getBaseUri());
    }

    @Bean(name = "contactsServiceClientObjectMapper")
    public ObjectMapper contactsServiceClientObjectMapper() {
        return JsonMapper.builder()
                .addModule(new Jdk8Module())
                .addModule(new JavaTimeModule())
                .build();
    }
}
