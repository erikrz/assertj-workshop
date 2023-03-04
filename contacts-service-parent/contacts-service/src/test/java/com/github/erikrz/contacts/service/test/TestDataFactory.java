/*
 * Copyright (c) 2023 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.github.erikrz.contacts.service.test;


import java.time.Instant;

import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;
import com.github.erikrz.contacts.service.model.Contact;

public class TestDataFactory {



    public static CreateContactDto getCreateContactDto(){
        return CreateContactDto.builder()
                .firstName("Erik")
                .lastName("Rz")
                .email("erikrz@github.com")
                .phoneNumber("(123) 456 7890")
                .build();
    }

    public static ContactDto getContactDto(){
        return ContactDto.builder()
                .id(1L)
                .firstName("Erik")
                .lastName("Rz")
                .email("erikrz@github.com")
                .phoneNumber("(123) 456 7890")
                .build();

    }
    public static Contact getContact(){
     return    Contact.builder()
             .id(1L)
             .firstName("Erik")
             .lastName("Rz")
             .email("erikrz@github.com")
             .phoneNumber("(123) 456 7890")
             .createdByUser("someone")
             .modifiedByUser("someone")
             .createdDate(Instant.ofEpochSecond(1680015600))
             .lastModifiedDate(Instant.ofEpochSecond(1680015660))
             .build();
    }





}
