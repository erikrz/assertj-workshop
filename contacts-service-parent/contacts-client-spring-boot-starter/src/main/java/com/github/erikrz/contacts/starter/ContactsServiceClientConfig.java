package com.github.erikrz.contacts.starter;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.github.erikrz.contacts.client.feign.configuration.ContactsServiceClientConfiguration;
import com.github.erikrz.contacts.client.feign.properties.ContactsClientProperties;
import com.github.erikrz.contacts.client.feign.targets.ContactsNonIdempotentClient;

/**
 * Contacts Service Client Auto Configuration.
 * Spring Configuration class that configures and instances the Contacts Service Client.
 * Just {@code @import} this configuration class into your application, provide the required properties defined in
 * {@link ContactsClientProperties} and you are good to go and use the {@link ContactsNonIdempotentClient} bean.
 */
@Import(ContactsServiceClientConfiguration.class)
@AutoConfiguration
public class ContactsServiceClientConfig {

}
