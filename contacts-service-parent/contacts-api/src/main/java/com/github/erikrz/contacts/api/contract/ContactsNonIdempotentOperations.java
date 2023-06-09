package com.github.erikrz.contacts.api.contract;

import jakarta.validation.Valid;

import com.github.erikrz.contacts.api.dto.ExceptionMessage;
import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface ContactsNonIdempotentOperations {

    /**
     * Create a contact by invoking POST {@value ContactsPaths#BASE_PATH} .
     *
     * @param contact the contact data.
     * @return the created contact.
     */
    @Operation(
            summary = "POST to create a single contact",
            operationId = "createContact",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ContactDto.class)),
                            headers = {
                                    @Header(
                                            name = "location",
                                            description = "resource path where the created contact can be found")
                            },
                            links = {@Link(operationId = "getContactById")}),
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
                            responseCode = "500",
                            description = "Internal Server Error.")
            }
    )
    ContactDto createContact(@Valid @RequestBody CreateContactDto contact);

}
