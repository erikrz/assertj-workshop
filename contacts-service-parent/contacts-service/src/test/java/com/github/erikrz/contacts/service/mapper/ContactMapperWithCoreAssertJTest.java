package com.github.erikrz.contacts.service.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.service.test.TestDataFactory;

import static org.assertj.core.api.Assertions.assertThat;

class ContactMapperWithCoreAssertJTest {

    public final CreateContactDto updateContact = CreateContactDto.builder()
            .firstName("Erik")
            .lastName("Rios")
            .email("erik.rios@nextiva.com")
            .phoneNumber("+52 (123) 456 7890")
            .build();
    ;
    private final ContactMapper contactMapper = Mappers.getMapper(ContactMapper.class);

    @Test
    void toContact() {
        var createContactDto = TestDataFactory.getCreateContactDto();

        var resultingContact = contactMapper.toContact(createContactDto);

        assertThat(resultingContact.getId()).isNull();
        assertThat(resultingContact.getFirstName()).isEqualTo("Erik");
        assertThat(resultingContact.getLastName()).isEqualTo("Rz");
        assertThat(resultingContact.getEmail()).isEqualTo("erikrz@github.com");
        assertThat(resultingContact.getPhoneNumber()).isEqualTo("(123) 456 7890");
        assertThat(resultingContact.getCreatedByUser()).isNull();
        assertThat(resultingContact.getModifiedByUser()).isNull();
        assertThat(resultingContact.getCreatedDate()).isNull();
        assertThat(resultingContact.getLastModifiedDate()).isNull();

    }

    @Test
    void testToContact() {
        var contactDto = TestDataFactory.getContactDto();

        var resultingContact = contactMapper.toContact(contactDto);

        assertThat(resultingContact.getId()).isEqualTo(1L);
        assertThat(resultingContact.getFirstName()).isEqualTo("Erik");
        assertThat(resultingContact.getLastName()).isEqualTo("Rz");
        assertThat(resultingContact.getEmail()).isEqualTo("erikrz@github.com");
        assertThat(resultingContact.getPhoneNumber()).isEqualTo("(123) 456 7890");
        assertThat(resultingContact.getCreatedByUser()).isNull();
        assertThat(resultingContact.getModifiedByUser()).isNull();
        assertThat(resultingContact.getCreatedDate()).isNull();
        assertThat(resultingContact.getLastModifiedDate()).isNull();
    }

    @Test
    void toContactDto() {
        var contact = TestDataFactory.getContact();

        var resultingContactDto = contactMapper.toContactDto(contact);

        assertThat(resultingContactDto.getId()).isEqualTo(1L);
        assertThat(resultingContactDto.getFirstName()).isEqualTo("Erik");
        assertThat(resultingContactDto.getLastName()).isEqualTo("Rz");
        assertThat(resultingContactDto.getEmail()).isEqualTo("erikrz@github.com");
        assertThat(resultingContactDto.getPhoneNumber()).isEqualTo("(123) 456 7890");
        assertThat(resultingContactDto.getCreatedDate()).isEqualTo("2023-03-28T15:00:00.00Z");
        assertThat(resultingContactDto.getLastModifiedDate()).isEqualTo("2023-03-28T15:01:00.00Z");
    }

    @Test
    void updateContactFromDto() {
        var contact = TestDataFactory.getContact();

        contactMapper.updateFromCreateContactDto(updateContact, contact);

        assertThat(contact.getId()).isEqualTo(1L);
        assertThat(contact.getFirstName()).isEqualTo("Erik");
        assertThat(contact.getLastName()).isEqualTo("Rios");
        assertThat(contact.getEmail()).isEqualTo("erik.rios@nextiva.com");
        assertThat(contact.getPhoneNumber()).isEqualTo("+52 (123) 456 7890");
        assertThat(contact.getCreatedByUser()).isEqualTo("someone");
        assertThat(contact.getModifiedByUser()).isEqualTo("someone");
        assertThat(contact.getCreatedDate()).isEqualTo("2023-03-28T15:00:00.00Z");
        assertThat(contact.getLastModifiedDate()).isEqualTo("2023-03-28T15:01:00.00Z");
    }
}