package com.github.erikrz.contacts.service.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;
import com.github.erikrz.contacts.service.service.ContactsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "rest-api/v1")
public class ContactsController {

    private final ContactsService contactsService;

    @Autowired
    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Operation(summary = "POST to create a single contact", operationId = "createContact")
    @ApiResponse(responseCode = "201", headers = {
            @Header(name = "location", description = "resource path where the created contact can be found")},
            links = {@Link(operationId = "getContactById")})
    @ApiResponse(responseCode = "400", content = @Content(
            schema = @Schema(implementation = ErrorAttributes.class, subTypes = DefaultErrorAttributes.class,
                    example = """
                            {
                                "timestamp": 1665764391370,
                                "status": 400,
                                "error": "Bad Request",
                                "message": "JSON parse error",
                                "path": "/rest-api/v1/contacts"
                            }
                              """)))
    @PostMapping(value = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactDto> createContact(@RequestBody CreateContactDto contact) {
        log.trace("contact({})", contact);
        var savedContact = this.contactsService.saveContact(contact);
        var location = URI.create(String.format("/rest-api/v1/contacts/%d", savedContact.getId()));
        return ResponseEntity.created(location)
                .body(savedContact);
    }

    @Operation(summary = "GET all contacts", operationId = "getContacts")
    @ApiResponse(responseCode = "200")
    @GetMapping(value = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContactDto>> getContacts() {
        var contacts = this.contactsService.getContacts();
        return ResponseEntity.ok(contacts);
    }

    @Operation(summary = "GET a single contact", operationId = "getContactById")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400")
    @ApiResponse(responseCode = "404")
    @GetMapping(value = "/contacts/{contactId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactDto> getContactById(
            @Parameter(description = "Contact Id", example = "1")
            @PathVariable("contactId")
            Long contactId) {
        var contact = this.contactsService.getContactById(contactId);
        if (contact.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contact.get());
    }

    @Operation(summary = "Update a single contact", operationId = "updateContactById")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400")
    @ApiResponse(responseCode = "404")
    @PutMapping(value = "/contacts/{contactId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactDto> updateContactById(
            @Parameter(description = "Contact Id", example = "1")
            @PathVariable("contactId")
            Long contactId,
            @RequestBody CreateContactDto updatedContact) {
        var contact = this.contactsService.updateContactById(contactId, updatedContact);
        if (contact.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contact.get());
    }

    @Operation(summary = "Delete a single contact", operationId = "deleteContactById")
    @ApiResponse(responseCode = "204")
    @ApiResponse(responseCode = "404")
    @DeleteMapping(value = "/contacts/{contactId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteContactById(
            @Parameter(description = "Contact Id", example = "1")
            @PathVariable("contactId")
            Long contactId) {
        var contact = this.contactsService.deleteContactById(contactId);
        if (contact.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
