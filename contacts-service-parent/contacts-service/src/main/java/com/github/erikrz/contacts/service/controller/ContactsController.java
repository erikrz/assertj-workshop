package com.github.erikrz.contacts.service.controller;

import java.util.Optional;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.github.erikrz.contacts.service.mapper.ContactMasker;
import com.github.erikrz.contacts.service.service.ContactsService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import static com.github.erikrz.contacts.api.contract.ContactsPaths.BASE_PATH;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@Slf4j
@RestController
@RequestMapping(value = BASE_PATH)
public class ContactsController implements ContactsIdempotentOperations, ContactsNonIdempotentOperations {

    private final ContactsService contactsService;
    private final ContactMasker contactMasker;

    @Autowired
    public ContactsController(ContactsService contactsService, ContactMasker contactMasker) {
        this.contactsService = contactsService;
        this.contactMasker = contactMasker;
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
        var savedContactLocation = fromCurrentRequest().build().toUri() + "/" + savedContact.getId();
        getThreadLocalResponse().ifPresent(response -> response.setHeader("location", savedContactLocation));
        log.trace("createdContact: {}", contactMasker.mask(savedContact));
        return savedContact;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    @PageableAsQueryParam
    public Page<ContactDto> getAllContacts(Pageable pageable) {
        return this.contactsService.getAllContacts(pageable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{contactId}")
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
    @PutMapping("/{contactId}")
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
    @DeleteMapping("/{contactId}")
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
