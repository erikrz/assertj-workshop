package com.github.erikrz.contacts.client.feign.targets;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.github.erikrz.contacts.api.contract.ContactsIdempotentOperations;
import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;

import feign.Body;
import feign.Param;
import feign.RequestLine;

import static com.github.erikrz.contacts.api.contract.ContactsPaths.ALL_CONTACTS_PATH;
import static com.github.erikrz.contacts.api.contract.ContactsPaths.SINGLE_CONTACT_PATH;

/**
 * Contacts idempotent Client.
 *
 * @author erikrios
 */
public interface ContactsIdempotentClient extends ContactsIdempotentOperations {

    /**
     * GET all contacts.
     *
     * @return a list containing all the contacts.
     */
    @Override
    @RequestLine("GET " + ALL_CONTACTS_PATH)
    Page<ContactDto> getAllContacts(Pageable pageable);

    /**
     * Get a single contact.
     *
     * @param contactId The unique Id of the contact to retrieve.
     * @return the existing contact.
     */
    @Override
    @RequestLine("GET " + SINGLE_CONTACT_PATH)
    ContactDto getContact(@Param("contactId") Long contactId);


    /**
     * Updates a single contact.
     *
     * @param contactId        the id of the contact to update.
     * @param createContactDto new data for the existing contact.
     * @return the updated contact.
     */
    @Override
    @Body("{createContactDto}")
    @RequestLine("PUT " + SINGLE_CONTACT_PATH)
    ContactDto updateContact(
            @Param("contactId") Long contactId,
            @Param("createContactDto") CreateContactDto createContactDto);

    /**
     * Deletes a single contact.
     *
     * @param contactId The Id of the contact to delete.
     */
    @Override
    @RequestLine("DELETE " + SINGLE_CONTACT_PATH)
    void deleteContact(@Param("contactId") Long contactId);

}
