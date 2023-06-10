package com.github.erikrz.contacts.service.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ContactMaskerTest {
    private final ContactMasker contactMasker = Mappers.getMapper(ContactMasker.class);


    @Test
    void maskEmail() {
        assertNull(contactMasker.maskEmail(null));
        assertEquals("", contactMasker.maskEmail(""));
        assertEquals("null", contactMasker.maskEmail("null"));
        assertEquals("eri****@live.com", contactMasker.maskEmail("erik.rz@live.com"));
    }

    @Test
    void maskPhoneNumber() {
        assertNull(contactMasker.maskPhoneNumber(null));
        assertEquals("", contactMasker.maskPhoneNumber(""));
        assertEquals("null", contactMasker.maskPhoneNumber("null"));
        assertEquals("(***) *** ****", contactMasker.maskPhoneNumber("(123) 456 7890"));
        assertEquals("+**(***) *** ****", contactMasker.maskPhoneNumber("+52(123) 456 7890"));
    }
}