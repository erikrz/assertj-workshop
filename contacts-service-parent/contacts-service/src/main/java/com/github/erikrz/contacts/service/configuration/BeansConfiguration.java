package com.github.erikrz.contacts.service.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.erikrz.contacts.service.mapper.ContactMapper;
import com.github.erikrz.contacts.service.mapper.ContactMasker;
import com.github.erikrz.contacts.service.repository.ContactsRepository;
import com.github.erikrz.contacts.service.service.ContactsService;
import com.github.erikrz.contacts.service.service.ContactsServiceImpl;

/**
 * Beans Configuration.
 */
@Configuration
public class BeansConfiguration {

    @Bean
    public ContactMapper contactMapper() {
        return Mappers.getMapper(ContactMapper.class);
    }

    @Bean
    public ContactMasker contactMasker() {
        return Mappers.getMapper(ContactMasker.class);
    }

    @Bean
    public ContactsService contactsService(ContactsRepository contactsRepository, ContactMapper contactMapper,
                                           ContactMasker contactMasker) {
        return new ContactsServiceImpl(contactsRepository, contactMapper, contactMasker);
    }

}
