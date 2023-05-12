
package com.github.erikrz.contacts.api.dto;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 * Model to describe Validation exceptions.
 *
 * @see ObjectError
 * @see BindingResult
 */
@Jacksonized
@Builder(toBuilder = true)
@Data
@Schema(description = "Defines a model to describe Validation Messages.")
public class ValidationMessage {

    @JsonIgnore
    @Schema(description = "The codes used to resolve this message", example = "[\"NotBlank\"]")
    private final List<String> codes;

    @JsonIgnore
    @Schema(description = "The array of arguments used to resolve this message", example = """
                                                                            [
                                                                                    {
                                                                                      "codes": [
                                                                                        "createContactDto.firstName",
                                                                                        "firstName"
                                                                                      ],
                                                                                      "arguments": null,
                                                                                      "defaultMessage": "firstName",
                                                                                      "code": "firstName"
                                                                                    }
                                                                                  ]
            """)
    private final List<Object> arguments;

    @Schema(description = "The default message used to resolve this message", example = "must not be blank")
    private final String defaultMessage;

    @Schema(description = "The name of the affected object", example = "createContactDto")
    private final String objectName;

    @Schema(description = "The affected field of the object", example = "firstName")
    private final String field;

    @Schema(description = "The rejected field value.", example = " ")
    private final Object rejectedValue;

    @Schema(description = "Whether this error represents a binding failure (like a type mismatch); "
            + "otherwise it is a validation failure", example = "false")
    private final Boolean bindingFailure;

    @Schema(description = "The code that represents this error", example = "NotBlank")
    private final String code;
}
