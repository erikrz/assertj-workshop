package com.github.erikrz.contacts.service.mapper;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.service.test.TestDataFactory;

import static com.github.erikrz.contacts.api.dto.response.ContactDtoAssert.assertThat;
import static com.github.erikrz.contacts.service.model.ContactAssert.assertThat;

class ContactMapperWithGeneratedAssertJTest {

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

        assertThat(resultingContact)
                .hasFirstName("Erik")
                .hasLastName("Rz")
                .hasEmail("erikrz@github.com")
                .hasPhoneNumber("(123) 456 7890")
                .hasNoNullFieldsOrPropertiesExcept("id", "createdDate", "lastModifiedDate", "createdByUser",
                        "modifiedByUser");
    }

    @Test
    void testToContact() {
        var contactDto = TestDataFactory.getContactDto();

        var resultingContact = contactMapper.toContact(contactDto);

        assertThat(resultingContact)
                .hasId(1L)
                .hasFirstName("Erik")
                .hasLastName("Rz")
                .hasEmail("erikrz@github.com")
                .hasPhoneNumber("(123) 456 7890")
                .hasNoNullFieldsOrPropertiesExcept("createdDate", "lastModifiedDate", "createdByUser",
                        "modifiedByUser");
    }

    @Test
    void toContactDto() {
        var contact = TestDataFactory.getContact();

        var resultingContactDto = contactMapper.toContactDto(contact);

        assertThat(resultingContactDto)
                .hasId(1L)
                .hasFirstName("Erik")
                .hasLastName("Rz")
                .hasEmail("erikrz@github.com")
                .hasPhoneNumber("(123) 456 7890")
                .hasCreatedDate(Instant.parse("2023-03-28T15:00:00.00Z"))
                .hasLastModifiedDate(Instant.parse("2023-03-28T15:01:00.00Z"));
    }

    @Test
    void updateContactFromDto() {
        var contact = TestDataFactory.getContact();

        contactMapper.updateFromCreateContactDto(updateContact, contact);

        assertThat(contact)
                .hasFirstName("Erik")
                .hasLastName("Rios")
                .hasEmail("erik.rios@nextiva.com")
                .hasPhoneNumber("+52 (123) 456 7890")
                .hasCreatedByUser("someone")
                .hasModifiedByUser("someone")
                .hasCreatedDate(Instant.parse("2023-03-28T15:00:00.00Z"))
                .hasLastModifiedDate(Instant.parse("2023-03-28T15:01:00.00Z"));
    }
}