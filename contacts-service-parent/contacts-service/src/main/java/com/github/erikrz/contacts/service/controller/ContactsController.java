package com.github.erikrz.contacts.service.controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

import com.github.erikrz.contacts.api.contract.ContactsIdempotentOperations;
import com.github.erikrz.contacts.api.contract.ContactsNonIdempotentOperations;
import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;
import com.github.erikrz.contacts.service.service.ContactsService;

import lombok.extern.slf4j.Slf4j;

import static com.github.erikrz.contacts.api.contract.ContactsPaths.BASE_PATH;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@Slf4j
@RestController
@RequestMapping(value = BASE_PATH)
public class ContactsController implements ContactsIdempotentOperations, ContactsNonIdempotentOperations {

    private final ContactsService contactsService;

    @Autowired
    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ContactDto createContact(@RequestBody CreateContactDto contact) {
        log.trace("createContact({})", contact);
        var savedContact = this.contactsService.saveContact(contact);
        getThreadLocalResponse()
                .ifPresent(httpServletResponse -> httpServletResponse.setHeader(
                        "location",
                        fromCurrentRequest().build().toUri() + "/" + savedContact.getId()));
        log.trace("createdContact: {}", savedContact);
        return savedContact;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ContactDto> getAllContacts() {
        return this.contactsService.getContacts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{contactId}")
    public ContactDto getContact(
            @PathVariable("contactId")
            Long contactId) {
        var contact = this.contactsService.getContactById(contactId);
        return contact.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{contactId}")
    public ContactDto updateContact(
            @PathVariable("contactId")
            Long contactId,
            @RequestBody
            CreateContactDto updatedContact) {
        var contact = this.contactsService.updateContactById(contactId, updatedContact);
        return contact.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{contactId}")
    public void deleteContact(
            @PathVariable("contactId")
            Long contactId) {
        var contact = this.contactsService.deleteContactById(contactId);
        if (contact.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public static Optional<HttpServletResponse> getThreadLocalResponse() {
        return Optional.ofNullable(RequestContextHolder.getRequestAttributes())
                .filter(ServletRequestAttributes.class::isInstance)
                .map(ServletRequestAttributes.class::cast)
                .map(ServletRequestAttributes::getResponse);
    }

}
