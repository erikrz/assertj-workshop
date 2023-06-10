package com.github.erikrz.contacts.service.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;
import com.github.erikrz.contacts.service.mapper.ContactMapper;
import com.github.erikrz.contacts.service.model.Contact;
import com.github.erikrz.contacts.service.repository.ContactsRepository;
import com.github.erikrz.contacts.service.test.TestDataFactory;

import static com.github.erikrz.contacts.api.dto.response.ContactDtoAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests that verifies the ContactsService behavior.
 */
@ExtendWith(SpringExtension.class)
class ContactsServiceImplTest {

    private final ContactMapper contactMapper = Mappers.getMapper(ContactMapper.class);
    private final ContactDto savedContact = ContactDto.builder()
            .id(1L)
            .firstName("Erik")
            .lastName("Rz")
            .email("erikrz@github.com")
            .phoneNumber("(123) 456 7890")
            .createdDate(Instant.ofEpochSecond(1680015600))
            .lastModifiedDate(Instant.ofEpochSecond(1680015660))
            .build();
    private final CreateContactDto updateContact = CreateContactDto.builder()
            .firstName("Erik")
            .lastName("Rz")
            .email("erik.rz@github.com")
            .phoneNumber("(123) 456 7890")
            .build();

    @Mock
    private ContactsRepository contactsRepository;

    private ContactsService contactsService;

    @BeforeEach
    public void initialize() {
        contactsService = new ContactsServiceImpl(contactsRepository, contactMapper);
    }

    @Test
    void whenSaveContact_thenReturnsValidSavedContact() {
        var createContactDto = TestDataFactory.getCreateContactDto();
        var contact = TestDataFactory.getContact();
        when(contactsRepository.save(any(Contact.class)))
                .thenReturn(contact);

        var result = contactsService.saveContact(createContactDto);

        assertThat(result)
                .isEqualTo(savedContact);
        verify(contactsRepository).save(any(Contact.class));
    }

    @Test
    void whenGetContacts_thenReturnsValidListOfContacts() {
        when(contactsRepository.findAll())
                .thenReturn(List.of(contactMapper.toContact(savedContact)));

        var result = contactsService.getAllContacts();

        assertThat(result)
                .isNotNull()
                .hasSize(1)
                .containsExactly(savedContact);
        verify(contactsRepository).findAll();
    }

    @Test
    void whenUpdateInexistingContact_thenReturnsEmpty() {
        when(contactsRepository.findById(2L))
                .thenReturn(Optional.empty());

        var result = contactsService.updateContactById(2L, updateContact);

        assertThat(result)
                .isEmpty();
        verify(contactsRepository).findById(2L);
    }

    @Test
    void whenUpdateContact_thenReturnsUpdatedContact() {
        var existingContact = TestDataFactory.getContact();
        var updatedContact = TestDataFactory.getContact();
        updatedContact.setEmail("erik.rz@github.com");
        when(contactsRepository.findById(1L))
                .thenReturn(Optional.of(existingContact));
        when(contactsRepository.save(updatedContact))
                .thenReturn(updatedContact);

        var result = contactsService.updateContactById(1L, updateContact);

        assertThat(result)
                .isPresent();
        verify(contactsRepository).findById(1L);
        verify(contactsRepository).save(updatedContact);
    }

    @Test
    void whenDeleteUnexistingContact_thenReturnsEmpty() {
        when(contactsRepository.findById(2L)).thenReturn(Optional.empty());

        var result = contactsService.deleteContactById(2L);

        assertThat(result)
                .isEmpty();
        verify(contactsRepository).findById(2L);
        verify(contactsRepository, never()).deleteById(2L);
    }

    @Test
    void whenDeleteContact_thenReturnsDeletedContact() {
        when(contactsRepository.findById(1L))
                .thenReturn(Optional.of(contactMapper.toContact(savedContact)));

        var result = contactsService.deleteContactById(1L);

        assertThat(result)
                .isPresent();
        verify(contactsRepository).findById(1L);
        verify(contactsRepository).deleteById(1L);
    }

}
