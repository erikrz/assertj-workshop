package com.github.erikrz.contacts.api.contract;

import java.util.List;

import jakarta.validation.Valid;

import com.github.erikrz.contacts.api.dto.ExceptionMessage;
import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface ContactsIdempotentOperations {

    /**
     * GET all contacts by invoking GET {@value ContactsPaths#ALL_CONTACTS_PATH} .
     *
     * @return the created contact.
     */
    @Operation(
            summary = "GET all contacts",
            operationId = "getAllContacts",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = List.class)),
                            links = {@Link(operationId = "getContact")}),
                    @ApiResponse(
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionMessage.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                                {
                                                                  "timestamp": 1683918886817,
                                                                  "status": 404,
                                                                  "error": "Not Found",
                                                                  "message": "404 NOT_FOUND",
                                                                  "path": "/rest-api/v1/contacts"
                                                                }
                                                            """)
                                    }
                            ),
                            description = "Contacts to retrieve not found."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionMessage.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                                {
                                                                  "timestamp": 1683919144302,
                                                                  "status": 500,
                                                                  "error": "Internal Server Error",
                                                                  "message": "No message available",
                                                                  "path": "/rest-api/v1/contacts/1"
                                                                }
                                                            """
                                            )
                                    }
                            ),
                            description = "Internal Server Error.")
            }
    )
    List<ContactDto> getAllContacts();

    /**
     * GET a single contact by invoking GET {@value ContactsPaths#SINGLE_CONTACT_PATH} .
     *
     * @return the contact.
     */
    @Operation(
            summary = "GET a single contact",
            operationId = "getContact",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ContactDto.class)),
                            headers = {
                                    @Header(
                                            name = "location",
                                            description = "resource path where the created contact can be found")},
                            links = {@Link(operationId = "getContact")}),
                    @ApiResponse(
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionMessage.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                                {
                                                                  "timestamp": 1683918886817,
                                                                  "status": 404,
                                                                  "error": "Not Found",
                                                                  "message": "404 NOT_FOUND",
                                                                  "path": "/rest-api/v1/contacts/1"
                                                                }
                                                            """)
                                    }
                            ),
                            description = "Contact to retrieve not found."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionMessage.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                                {
                                                                  "timestamp": 1683919144302,
                                                                  "status": 500,
                                                                  "error": "Internal Server Error",
                                                                  "message": "No message available",
                                                                  "path": "/rest-api/v1/contacts/1"
                                                                }
                                                            """)
                                    }
                            ),
                            description = "Internal Server Error.")
            }
    )
    ContactDto getContact(
            @Parameter(name = "contactId", description = "Contact Id", example = "1")
            Long contactId);

    /**
     * UPDATE a single contact by invoking PUT {@value ContactsPaths#SINGLE_CONTACT_PATH} .
     *
     * @return the updated contact.
     */
    @Operation(
            summary = "Update a single contact",
            operationId = "updateContact",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ContactDto.class)),
                            links = {@Link(operationId = "getContact")}),
                    @ApiResponse(
                            responseCode = "400",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionMessage.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                                      {
                                                                          "timestamp": 1665764391370,
                                                                          "status": 400,
                                                                          "error": "Bad Request",
                                                                          "message": "JSON parse error",
                                                                          "path": "/rest-api/v1/contacts/1"
                                                                      }
                                                            """)
                                    }
                            ),
                            description = "Bad request."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionMessage.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                                {
                                                                  "timestamp": 1683918886817,
                                                                  "status": 404,
                                                                  "error": "Not Found",
                                                                  "message": "404 NOT_FOUND",
                                                                  "path": "/rest-api/v1/contacts/1"
                                                                }
                                                            """)
                                    }
                            ),
                            description = "Contact to update not found."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionMessage.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                                {
                                                                  "timestamp": 1683919144302,
                                                                  "status": 500,
                                                                  "error": "Internal Server Error",
                                                                  "message": "No message available",
                                                                  "path": "/rest-api/v1/contacts/1"
                                                                }
                                                            """
                                            )
                                    }
                            ),
                            description = "Internal Server Error.")
            }
    )
    ContactDto updateContact(
            @Parameter(name = "contactId", description = "Contact Id", example = "1")
            Long contactId,
            @Valid
            @RequestBody
            CreateContactDto updatedContact);

    /**
     * DELETE a single contact by invoking DELETE {@value ContactsPaths#SINGLE_CONTACT_PATH} .
     *
     * @return the updated contact.
     */
    @Operation(
            summary = "Delete a single contact",
            operationId = "deleteContact",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ContactDto.class)),
                            links = {@Link(operationId = "getContact")}),
                    @ApiResponse(
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionMessage.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                                {
                                                                  "timestamp": 1683918886817,
                                                                  "status": 404,
                                                                  "error": "Not Found",
                                                                  "message": "404 NOT_FOUND",
                                                                  "path": "/rest-api/v1/contacts/1"
                                                                }
                                                            """)
                                    }
                            ),
                            description = "Contact to delete not found."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionMessage.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                                {
                                                                  "timestamp": 1683919144302,
                                                                  "status": 500,
                                                                  "error": "Internal Server Error",
                                                                  "message": "No message available",
                                                                  "path": "/rest-api/v1/contacts/1"
                                                                }
                                                            """
                                            )
                                    }
                            ),
                            description = "Internal Server Error.")
            }
    )
    void deleteContact(
            @Parameter(name = "contactId", description = "Contact Id", example = "1")
            Long contactId);

}
