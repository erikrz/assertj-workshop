package com.github.erikrz.contacts.api.dto.response;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder(toBuilder = true)
@Data
@Schema(description = "Defines a metadata model for units movement.")
public class ContactDto {

    @Schema(description = "Id of the contact.", example = "1")
    private final Long id;

    @Schema(description = "Contact's first Name.", example = "John")
    private final String firstName;

    @Schema(description = "Contact's Last Name.", example = "Doe")
    private final String lastName;

    @Schema(description = "Contact's email address.", example = "john.doe@github.com")
    private final String email;

    @Schema(description = "Contact's phone number.", example = "123-456-1234")
    private final String phoneNumber;

    @Schema(description = "Instant when this contact was first created in the system.")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private final Instant createdDate;

    @Schema(description = "Instant when this contact was last Modified in the system.")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private final Instant lastModifiedDate;
}
