package com.github.erikrz.jdk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Sample tests that showcase distinct String testing methods between JUnit & AssertJ.
 */
@DisplayName("String tests")
class StringTests {

    private String username;
    private String mexicanPostalCode;

    @BeforeEach
    public void initialize() {
        username = "Luis Erik";
        mexicanPostalCode = "12345";
    }

    @Test
    void testEqualsJunit() {
        assertEquals("Luis Erik", username);
    }

    @Test
    void testEqualsAssertJ() {
        assertThat(username).isEqualTo("Luis Erik");
    }


    @Test
    void testEqualsIgnoreCaseJunit() {
        assertTrue(username.equalsIgnoreCase("luis erik"));
    }

    @Test
    void testEqualsIgnoreCaseAssertJ() {
        assertThat(username).isEqualToIgnoringCase("luis erik");
    }

    @Test
    void testIsBlankJunit() {
        assertFalse(username.isBlank());
    }

    @Test
    void testIsBlankAssertJ() {
        assertThat(username).isNotBlank();
    }

    @Test
    void testContainsJunit() {
        assertTrue(username.contains("Erik"));
        assertTrue(username.contains("Luis"));
    }

    @Test
    void testContainsAssertJ() {
        assertThat(username).contains("Erik", "Luis");
    }

    @Test
    void testPostalCodeJUnit() {
        assertTrue(mexicanPostalCode.matches("[0-9]+"));
        assertEquals(5, mexicanPostalCode.length());
    }

    @Test
    void testPostalCodeAssert() {
        assertThat(mexicanPostalCode).containsOnlyDigits().hasSize(5);
    }
}
