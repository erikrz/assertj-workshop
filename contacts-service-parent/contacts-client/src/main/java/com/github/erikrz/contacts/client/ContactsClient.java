package com.github.erikrz.contacts.client;

import java.util.List;

import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;

import feign.Param;
import feign.RequestLine;

/**
 * Meeting Orchestration Client.
 *
 * @author erikrios
 * @since 1.3.0
 */
public interface ContactsClient {

    /**
     * POST to create a single contact.
     * @param createContactDto data of the contact to create.
     * @return the created contact.
     */
    @RequestLine("POST /v1/contacts")
    ContactDto createContact(CreateContactDto createContactDto);

    /**
     * GET all contacts.
     * @return a list containing all the contacts.
     */
    @RequestLine("GET /v1/contacts")
    List<ContactDto> getContacts();

    /**
     * Get a single contact.
     * @param contactId The unique Id of the contact to retrieve.
     * @return the existing contact.
     */
    @RequestLine("GET /v1/contacts/{contact-id}")
    ContactDto getContact(@Param("contact-id") Long contactId);


    /**
     * Updates a single contact.
     * @param contactId the id of the contact to update.
     * @param createContactDto new data for the existing contact.
     * @return the updated contact.
     */
    @RequestLine("PUT /v1/contacts/{contact-id}")
    ContactDto updateContact(@Param("contact-id") Long contactId, CreateContactDto createContactDto);


    /**
     * Deletes a single contact.
     * @param meetingId The Id of the contact to delete.
     */
    @RequestLine("DELETE /v1/contacts/{contact-id}")
    void deleteMeeting(@Param("contact-id") String meetingId);


}
