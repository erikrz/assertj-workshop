
package com.github.erikrz.contacts.client.feign.decoder;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.erikrz.contacts.api.dto.ExceptionMessage;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * Custom error decoder for Feign exceptions.
 *
 * @author erikrios
 */
@Slf4j
public class ContactsErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder;
    private final ObjectMapper mapper;

    public ContactsErrorDecoder() {
        defaultErrorDecoder = new Default();
        mapper = new ObjectMapper();
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message;
        try (InputStream bodyIs = response.body().asInputStream()) {
            message = mapper.readValue(bodyIs, ExceptionMessage.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        return switch (response.status()) {
            case 400 -> new Exception(message.getMessage() != null ? message.getMessage() : "Bad Request");
            case 404 -> new Exception(message.getMessage() != null ? message.getMessage() : "Not found");
            default -> defaultErrorDecoder.decode(methodKey, response);
        };
    }

}
