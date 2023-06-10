/*
 * Copyright (c) 2023 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.github.erikrz.contacts.service.service;

import java.util.List;
import java.util.Optional;

import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;

/**
 * Service interfaces that describes contact operations.
 */
public interface ContactsService {

    /**
     * Function to save a contact.
     * @param createContactDto dto containing data to save a new contact.
     * @return the saved contact information.
     */
    ContactDto saveContact(CreateContactDto createContactDto);

    /**
     * Function to retrieve all existing contacts.
     * @return a list containing all contacts.
     */
    List<ContactDto> getAllContacts();

    /**
     * Function to get a contact by its Id.
     * @param id the contact ID.
     * @return the found contact, if any.
     */
    Optional<ContactDto> getContactById(Long id);

    /**
     * Function to update a contact with new data.
     * @param id the contact ID.
     * @param updatedContactDto the new info to be persisted in the given contact.
     * @return the updated contact, if any.
     */
    Optional<ContactDto> updateContactById(Long id, CreateContactDto updatedContactDto);

    /**
     * Function to delete a contact.
     * @param id the ID of the contact to delete.
     * @return the deleted contact, if any.
     */
    Optional<ContactDto> deleteContactById(Long id);
}
