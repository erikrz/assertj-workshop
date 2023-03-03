package com.github.erikrz.contacts.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;
import com.github.erikrz.contacts.service.model.Contact;

@Mapper
public interface ContactMapper {

    Contact toContact(CreateContactDto contact);

    Contact toContact(ContactDto contact);

    ContactDto toContactDto(Contact contact);

    void updateFromCreateContactDto(CreateContactDto contactDto, @MappingTarget Contact contact);

}
