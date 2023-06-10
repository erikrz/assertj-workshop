package com.github.erikrz.contacts.service.service;

import java.util.List;
import java.util.Optional;

import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;
import com.github.erikrz.contacts.service.mapper.ContactMapper;
import com.github.erikrz.contacts.service.repository.ContactsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service that persists contacts.
 */
@Slf4j
@RequiredArgsConstructor
public class ContactsServiceImpl implements ContactsService {

    private final ContactsRepository contactsRepository;
    private final ContactMapper contactMapper;

    @Override
    public ContactDto saveContact(CreateContactDto createContactDto) {
        log.trace("saveContact(createContactDto={})", createContactDto);
        var contactToPersist = contactMapper.toContact(createContactDto);
        var persistedContact = contactsRepository.save(contactToPersist);
        return contactMapper.toContactDto(persistedContact);
    }

    @Override
    public List<ContactDto> getAllContacts() {
        log.trace("getContacts()");
        var persistedContacts = contactsRepository.findAll();
        return persistedContacts.stream()
                .map(contactMapper::toContactDto)
                .toList();
    }

    @Override
    public Optional<ContactDto> getContactById(Long id) {
        log.trace("getContactById(id={})", id);
        var persistedContact = contactsRepository.findById(id);
        return persistedContact.map(contactMapper::toContactDto);
    }

    @Override
    public Optional<ContactDto> updateContactById(Long id, CreateContactDto updatedContactDto) {
        log.trace("getContactById(id={}, updatedContactDto={})", id, updatedContactDto);
        var existingContact = contactsRepository.findById(id);
        if (existingContact.isEmpty()) {
            return Optional.empty();
        }
        var contactToUpdate = existingContact.get();
        contactMapper.updateFromCreateContactDto(updatedContactDto, contactToUpdate);
        var updatedContact = contactsRepository.save(contactToUpdate);
        return Optional.of(contactMapper.toContactDto(updatedContact));
    }

    @Override
    public Optional<ContactDto> deleteContactById(Long id) {
        log.trace("deleteContactById(id={})", id);
        var existingContact = contactsRepository.findById(id);
        if (existingContact.isEmpty()) {
            return Optional.empty();
        }
        var contactToDelete = existingContact.get();
        contactsRepository.deleteById(id);
        return Optional.of(contactMapper.toContactDto(contactToDelete));
    }

}
