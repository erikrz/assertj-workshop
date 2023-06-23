package com.github.erikrz.contacts.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;

@Mapper
public interface ContactMasker {

    String MASK_EMAIL_REGEX = "(?<=.{3}).(?=[^@]*?@)";
    String MASK_PHONE_NUMBER_REGEX = "\\d";

    @Mapping(target = "email", qualifiedByName = "maskEmail")
    @Mapping(target = "phoneNumber", qualifiedByName = "maskPhoneNumber")
    ContactDto mask(ContactDto contact);

    @Mapping(target = "email", qualifiedByName = "maskEmail")
    @Mapping(target = "phoneNumber", qualifiedByName = "maskPhoneNumber")
    CreateContactDto mask(CreateContactDto contact);

    @Named("maskPhoneNumber")
    default String maskPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        return phoneNumber.replaceAll(MASK_PHONE_NUMBER_REGEX, "*");
    }

    @Named("maskEmail")
    default String maskEmail(String email) {
        if (email == null) {
            return null;
        }
        return email.replaceAll(MASK_EMAIL_REGEX, "*");
    }

}
