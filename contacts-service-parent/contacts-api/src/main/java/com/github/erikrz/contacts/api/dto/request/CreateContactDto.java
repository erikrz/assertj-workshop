package com.github.erikrz.contacts.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder(toBuilder = true)
@Data
@Schema(description = "Defines a model to create Contacts.")
public class CreateContactDto {

    @NotBlank
    @Schema(description = "Contact's first Name.", example = "John")
    private final String firstName;

    @NotBlank
    @Schema(description = "Contact's Last Name.", example = "Doe")
    private final String lastName;

    @Email
    @NotBlank
    @Schema(description = "Contact's email address.", example = "john.doe@github.com")
    private final String email;

    @Schema(description = "Contact's phone number.", example = "123-456-1234")
    private final String phoneNumber;

}
