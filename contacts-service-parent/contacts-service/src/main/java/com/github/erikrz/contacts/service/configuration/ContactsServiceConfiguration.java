package com.github.erikrz.contacts.service.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * When a Spring Boot Application runs, it scans for {@link Configuration} annotated classes, and classes with
 * stereotype annotations, such as
 * {@link org.springframework.stereotype.Component},
 * {@link org.springframework.stereotype.Controller},
 * {@link org.springframework.stereotype.Repository} and
 * {@link org.springframework.stereotype.Service}.
 * Once it reads them all, Spring sorts the declared beans in dependency order, instantiates them,
 * and store them in the Application Context.
 */
@Configuration
@EnableJpaRepositories("com.github.erikrz.contacts.service.repository")
@EnableJpaAuditing
public class ContactsServiceConfiguration {
}