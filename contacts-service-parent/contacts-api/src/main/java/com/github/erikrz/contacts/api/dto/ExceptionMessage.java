
package com.github.erikrz.contacts.api.dto;

import java.util.List;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 * Model to describe exceptions.
 *
 * @see ErrorAttributes
 * @see DefaultErrorAttributes
 */
@Jacksonized
@Builder(toBuilder = true)
@Data
@Schema(description = "Defines a model to describe Exceptions.")
public class ExceptionMessage {

    @Schema(description = "The time that the errors were extracted.", example = "1665764391370")
    private final long timestamp;

    @Schema(description = "The status code.", example = "400")
    private final int status;

    @Schema(description = "The error reason.", example = "Bad Request")
    private final String error;

    @Schema(description = "The class name of the root exception (if configured).", example = "NullPointerException")
    private final String exception;

    @Schema(description = "The exception message (if configured).", example = "Called method of a null object.")
    private final String message;

    @Schema(description = "Validation and bindingResult errors.", example = "[]")
    private final List<ValidationMessage> errors;

    @Schema(description = "The exception stack trace (if configured).", example = "java.lang.Exception: Stack trace\n"
            + "at java.base/java.lang.Thread.dumpStack(Thread.java:1383)")
    private final String trace;

    @Schema(description = "The URL path when the exception was raised.", example = "/rest-api/contacts")
    private final String path;
}
