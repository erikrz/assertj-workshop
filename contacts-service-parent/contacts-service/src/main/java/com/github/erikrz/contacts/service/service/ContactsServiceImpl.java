package com.github.erikrz.contacts.service.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;
import com.github.erikrz.contacts.service.mapper.ContactMapper;
import com.github.erikrz.contacts.service.mapper.ContactMasker;
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
    private final ContactMasker contactMasker;

    @Override
    public ContactDto saveContact(CreateContactDto createContactDto) {
        log.trace("saveContact(createContactDto={})", contactMasker.mask(createContactDto));
        var contactToPersist = contactMapper.toContact(createContactDto);
        var persistedContact = contactsRepository.save(contactToPersist);
        return contactMapper.toContactDto(persistedContact);
    }

    @Override
    public Page<ContactDto> getAllContacts(Pageable pageable) {
        log.trace("getAllContacts(pageable={})", pageable);
        return contactsRepository.findAll(pageable)
                .map(contactMapper::toContactDto);
    }

    @Override
    public Optional<ContactDto> getContactById(Long id) {
        log.trace("getContactById(id={})", id);
        return contactsRepository.findById(id)
                .map(contactMapper::toContactDto);
    }

    @Override
    public Optional<ContactDto> updateContactById(Long id, CreateContactDto updatedContactDto) {
        log.trace("getContactById(id={}, updatedContactDto={})", id, contactMasker.mask(updatedContactDto));
        return contactsRepository.findById(id)
                .map(contactToUpdate -> {
                    contactMapper.updateFromCreateContactDto(updatedContactDto, contactToUpdate);
                    var updatedContact = contactsRepository.save(contactToUpdate);
                    return contactMapper.toContactDto(updatedContact);
                });
    }

    @Override
    public Optional<ContactDto> deleteContactById(Long id) {
        log.trace("deleteContactById(id={})", id);
        return contactsRepository.findById(id)
                .map(contact -> {
                    contactsRepository.deleteById(contact.getId());
                    return contactMapper.toContactDto(contact);
                });
    }

}
