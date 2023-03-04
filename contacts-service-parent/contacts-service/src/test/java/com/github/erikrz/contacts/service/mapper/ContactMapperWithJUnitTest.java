package com.github.erikrz.contacts.service.mapper;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.service.test.TestDataFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ContactMapperWithJUnitTest {

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

        assertNull(resultingContact.getId());
        assertEquals("Erik", resultingContact.getFirstName());
        assertEquals("Rz", resultingContact.getLastName());
        assertEquals("erikrz@github.com", resultingContact.getEmail());
        assertEquals("(123) 456 7890", resultingContact.getPhoneNumber());
        assertNull(resultingContact.getCreatedByUser());
        assertNull(resultingContact.getModifiedByUser());
        assertNull(resultingContact.getCreatedDate());
        assertNull(resultingContact.getLastModifiedDate());
    }

    @Test
    void testToContact() {
        var contactDto = TestDataFactory.getContactDto();

        var resultingContact = contactMapper.toContact(contactDto);

        assertEquals(1, resultingContact.getId());
        assertEquals("Erik", resultingContact.getFirstName());
        assertEquals("Rz", resultingContact.getLastName());
        assertEquals("erikrz@github.com", resultingContact.getEmail());
        assertEquals("(123) 456 7890", resultingContact.getPhoneNumber());
        assertNull(resultingContact.getCreatedByUser());
        assertNull(resultingContact.getModifiedByUser());
        assertNull(resultingContact.getCreatedDate());
        assertNull(resultingContact.getLastModifiedDate());
    }

    @Test
    void toContactDto() {
        var contact = TestDataFactory.getContact();

        var resultingContactDto = contactMapper.toContactDto(contact);

        assertEquals(1, resultingContactDto.getId());
        assertEquals("Erik", resultingContactDto.getFirstName());
        assertEquals("Rz", resultingContactDto.getLastName());
        assertEquals("erikrz@github.com", resultingContactDto.getEmail());
        assertEquals("(123) 456 7890", resultingContactDto.getPhoneNumber());
        assertEquals(Instant.parse("2023-03-28T15:00:00.00Z"), contact.getCreatedDate());
        assertEquals(Instant.parse("2023-03-28T15:01:00.00Z"), contact.getLastModifiedDate());
    }

    @Test
    void updateContactFromDto() {
        var contact = TestDataFactory.getContact();

        contactMapper.updateFromCreateContactDto(updateContact, contact);

        assertEquals(1, contact.getId());
        assertEquals("Erik", contact.getFirstName());
        assertEquals("Rios", contact.getLastName());
        assertEquals("erik.rios@nextiva.com", contact.getEmail());
        assertEquals("+52 (123) 456 7890", contact.getPhoneNumber());
        assertEquals("someone", contact.getCreatedByUser());
        assertEquals("someone", contact.getModifiedByUser());
        assertEquals(Instant.parse("2023-03-28T15:00:00.00Z"), contact.getCreatedDate());
        assertEquals(Instant.parse("2023-03-28T15:01:00.00Z"), contact.getLastModifiedDate());
    }
}