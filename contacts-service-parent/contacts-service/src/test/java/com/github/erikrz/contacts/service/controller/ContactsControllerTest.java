package com.github.erikrz.contacts.service.controller;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.erikrz.contacts.api.dto.request.CreateContactDto;
import com.github.erikrz.contacts.api.dto.response.ContactDto;
import com.github.erikrz.contacts.service.mapper.ContactMasker;
import com.github.erikrz.contacts.service.service.ContactsService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests that verifies the ContactsController behavior.
 */
@MockBeans(@MockBean(ContactMasker.class))
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ContactsController.class)
class ContactsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ContactsService contactsService;

    private final CreateContactDto createContact = CreateContactDto.builder()
            .firstName("Erik")
            .lastName("Rz")
            .email("erikrz@github.com")
            .phoneNumber("(123) 456 7890")
            .build();

    private final ContactDto savedContact = ContactDto.builder()
            .id(1L)
            .firstName("Erik")
            .lastName("Rz")
            .email("erikrz@github.com")
            .phoneNumber("(123) 456 7890")
            .build();

    private final CreateContactDto updateContact = CreateContactDto.builder()
            .firstName("Erik")
            .lastName("Rz")
            .email("erik.rz@github.com")
            .phoneNumber("(123) 456 7890")
            .build();

    private final ContactDto updatedContact = ContactDto.builder()
            .id(1L)
            .firstName("Erik")
            .lastName("Rz")
            .email("erik.rz@github.com")
            .phoneNumber("(123) 456 7890")
            .build();


    @Test
    void whenValidInputForCreateContact_thenReturns201() throws Exception {
        when(contactsService.saveContact(createContact)).thenReturn(savedContact);

        mockMvc.perform(post("/rest-api/v1/contacts")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createContact)))
                .andExpectAll(
                        status().isCreated(),
                        header().string("location", "http://localhost/rest-api/v1/contacts/1"),
                        content().contentType(APPLICATION_JSON),
                        content().json(objectMapper.writeValueAsString(savedContact))
                );
    }

    @Test
    void whenNonParseableInputForCreateContact_thenReturns400() throws Exception {
        mockMvc.perform(post("/rest-api/v1/contacts")
                        .contentType(APPLICATION_JSON)
                        .content("[{}]"))
                .andExpectAll(
                        status().isBadRequest(),
                        result -> assertThat(result.getResolvedException())
                                .isInstanceOf(HttpMessageNotReadableException.class)
                );
    }

    @Test
    void whenInvalidInputForCreateContact_thenReturns400() throws Exception {
        mockMvc.perform(post("/rest-api/v1/contacts")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                    {
                                      "firstName": " ",
                                      "lastName": " ",
                                      "email": "john.doe @ github.com",
                                      "phoneNumber": " "
                                    }
                                """))
                .andExpectAll(
                        status().isBadRequest(),
                        result -> assertThat(result.getResolvedException())
                                .isInstanceOf(MethodArgumentNotValidException.class)
                );
    }

    @Test
    void whenGetAllContacts_thenReturns200() throws Exception {
        when(contactsService.getAllContacts()).thenReturn(List.of(savedContact));

        mockMvc.perform(get("/rest-api/v1/contacts/all"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(APPLICATION_JSON),
                        content().json(objectMapper.writeValueAsString(List.of(savedContact)))
                );
    }

    @Test
    void whenGetContactByValidId_thenReturns200() throws Exception {
        when(contactsService.getContactById(1L)).thenReturn(Optional.of(savedContact));

        mockMvc.perform(get("/rest-api/v1/contacts/{id}", 1L))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(APPLICATION_JSON),
                        content().json(objectMapper.writeValueAsString(savedContact))
                );
    }

    @Test
    void whenGetContactByInvalidId_thenReturns404() throws Exception {
        when(contactsService.getContactById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/rest-api/v1/contacts/{id}", 2L))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenGetContactByNotNumericId_thenReturns400() throws Exception {
        when(contactsService.getContactById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/rest-api/v1/contacts/{id}", "erik"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenValidInputForUpdateContact_thenReturns200() throws Exception {
        when(contactsService.updateContactById(1L, updateContact)).thenReturn(Optional.of(updatedContact));

        mockMvc.perform(put("/rest-api/v1/contacts/{id}", 1L)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateContact)))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(APPLICATION_JSON),
                        content().json(objectMapper.writeValueAsString(updatedContact))
                );
    }

    @Test
    void whenInvalidInputForUpdateContact_thenReturns400() throws Exception {
        when(contactsService.updateContactById(1L, updateContact)).thenReturn(Optional.of(updatedContact));

        mockMvc.perform(put("/rest-api/v1/contacts/{id}", 1L)
                        .contentType(APPLICATION_JSON)
                        .content("[{}]"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenUpdateContactByNotNumericId_thenReturns400() throws Exception {
        mockMvc.perform(put("/rest-api/v1/contacts/{id}", "erik"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenInvalidIdForUpdateContact_thenReturns404() throws Exception {
        when(contactsService.updateContactById(2L, updateContact)).thenReturn(Optional.empty());

        mockMvc.perform(put("/rest-api/v1/contacts/{id}", 2L)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateContact)))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenValidIdForDeleteContact_thenReturns204() throws Exception {
        when(contactsService.deleteContactById(1L)).thenReturn(Optional.of(savedContact));

        mockMvc.perform(delete("/rest-api/v1/contacts/{id}", 1L))
                .andExpect(status().isNoContent());
    }

    @Test
    void whenInvalidIdForDeleteContact_thenReturns404() throws Exception {
        when(contactsService.deleteContactById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/rest-api/v1/contacts/{id}", 2L)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateContact)))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenDeleteContactByNotNumericId_thenReturns400() throws Exception {
        mockMvc.perform(delete("/rest-api/v1/contacts/{id}", "erik"))
                .andExpect(status().isBadRequest());
    }

}